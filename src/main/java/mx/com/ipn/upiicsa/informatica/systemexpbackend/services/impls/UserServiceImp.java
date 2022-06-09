package mx.com.ipn.upiicsa.informatica.systemexpbackend.services.impls;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.ResultDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.UserDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.*;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
    private final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ResultDAO resultDAO;

    @Override
    public List<UserInfoDto> getAll() {
        List<User> list = userDAO.findAll();
        List <UserInfoDto> infoDtoList = new ArrayList<>();
        list.forEach(user -> {
            UserInfoDto infoDto = new UserInfoDto(user.getIdUser(), user.getUserName(), user.getEmailUser());

            infoDtoList.add(infoDto);
        });
        return infoDtoList;
    }

    @Override
    public User createUser(UserRegisterDTO userDto) {
        User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getUsername());
        String hash = argon2.hash(1, 1024, 1, user.getPasswordUser());
        user.setPasswordUser(hash);
        try {
            return userDAO.save(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicate entry " + user.getEmailUser() + " for key 'EMAIL_USER'");
        }
    }

    @Override
    public JwtUser existUser(LoginUser user) {
        String  pass = user.getPassword();
        try {
            User userInDB = userDAO.findUserByEmailUser(user.getEmail());
            if (argon2.verify(userInDB.getPasswordUser(),pass)){

                return new JwtUser(userInDB.getUserName(),userInDB.getIdUser(),"ROLE_USER");
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login data is incorrect");
        }catch (Exception e){
            logger.info("User not found");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login data is incorrect");
        }
    }

    @Override
    public UserSession getUser(Integer id) {
        User user = userDAO.findById(id).get();
        return new UserSession(user.getIdUser(),user.getUserName(), user.getEmailUser());
    }


    @Override
    public List<HistoricalDto> historicalRegisterUsers() {
        List<HistoricalDto> historical= new ArrayList<>();

        Date today = new Date(System.currentTimeMillis());
        Long countUser;
        Long countResult;
        for (int i = 4; i >= 0; i--) {
            long days = (long) i * 60 * 60 * 1000 * 24;
            Date date = new Date(System.currentTimeMillis() - days);

            countUser = userDAO.countUsersByCreatedAt(date);
            countResult = resultDAO.countResultsByCreatedAt(date);
            historical.add(new HistoricalDto(date, countUser, countResult));
        }
        return historical;
    }

    @Override
    public UserDto findUserById(Integer idUser) {
        Optional<User> userOptional = userDAO.findById(idUser);
        User user = userOptional.orElse(null);
        if (user==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        return new UserDto(user.getEmailUser(), user.getUserName(), user.getCreatedAt(), user.getResults());
    }


}

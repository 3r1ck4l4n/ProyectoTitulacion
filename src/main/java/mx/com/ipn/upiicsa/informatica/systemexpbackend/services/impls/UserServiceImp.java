package mx.com.ipn.upiicsa.informatica.systemexpbackend.services.impls;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.UserDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImp implements UserService {

    private Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
    private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
    @Autowired
    private UserDAO userDAO;

    @Override
    public User createUser(User user) {
        logger.info(user.toString());
        String hash = argon2.hash(1, 1024, 1, user.getPasswordUser());
        user.setPasswordUser(hash);
        try {
            return userDAO.save(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Duplicate entry " + user.getEmailUser() + " for key 'EMAIL_USER'"));
        }
    }

    @Override
    public JwtUser existUser(User user) {
        String  pass = user.getPasswordUser();
        try {
            User userInDB = userDAO.findUserByEmailUser(user.getEmailUser());
            if (argon2.verify(userInDB.getPasswordUser(),pass)){
                JwtUser jwtUser = new JwtUser(userInDB.getUserName(),userInDB.getIdUser(),"ROLE_USER");

                return jwtUser;
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, String.format("Login data is incorrect"));
        }catch (Exception e){
            logger.info("User not found");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, String.format("Login data is incorrect"));
        }
    }
}

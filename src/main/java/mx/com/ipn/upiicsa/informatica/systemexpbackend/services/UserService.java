package mx.com.ipn.upiicsa.informatica.systemexpbackend.services;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.*;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    List<UserInfoDto> getAll();

    User createUser(UserRegisterDTO user);

    JwtUser existUser(LoginUser user);

    UserSession getUser(Integer id);

    List<HistoricalDto> historicalRegisterUsers() throws ParseException;

    UserDto findUserById(Integer idUser);
}

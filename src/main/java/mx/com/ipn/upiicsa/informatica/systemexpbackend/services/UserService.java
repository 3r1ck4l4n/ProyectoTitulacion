package mx.com.ipn.upiicsa.informatica.systemexpbackend.services;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;

public interface UserService {
    User createUser(User user);

    JwtUser existUser(User user);

}

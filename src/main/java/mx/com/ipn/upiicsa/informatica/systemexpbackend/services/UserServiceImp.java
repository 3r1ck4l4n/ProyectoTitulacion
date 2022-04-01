package mx.com.ipn.upiicsa.informatica.systemexpbackend.services;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.UserDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean createUser(User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        String hash = argon2.hash(1,1024,1, user.getPasswordUser());
        user.setPasswordUser(hash);
        return userDAO.createUser(user);
    }
}

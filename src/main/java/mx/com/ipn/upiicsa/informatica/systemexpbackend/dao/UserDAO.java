package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> allUsers();
    public boolean createUser(User user);
}

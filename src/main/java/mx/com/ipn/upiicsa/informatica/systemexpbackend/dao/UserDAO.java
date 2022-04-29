package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    public User findUserByEmailUser(String email);
}

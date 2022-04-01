package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.daoImp;

import lombok.var;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.UserDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        var query = "from User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public boolean createUser(User user) {
        boolean status;

        try {
            entityManager.merge(user);
            status = true;
        }catch (Exception e){
            status = false;
        }

        return status;
    }
}

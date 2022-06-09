package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao;


import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDAO extends JpaRepository<Answer, Integer> {
}

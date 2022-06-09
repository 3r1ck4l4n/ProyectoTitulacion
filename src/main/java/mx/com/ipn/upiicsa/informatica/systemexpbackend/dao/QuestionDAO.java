package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
}

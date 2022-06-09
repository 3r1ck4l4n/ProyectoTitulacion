package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDAO extends JpaRepository<Test, Integer> {
    public Test findTestByIdTest(Integer idTest);
}

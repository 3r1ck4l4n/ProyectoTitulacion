package mx.com.ipn.upiicsa.informatica.systemexpbackend.services.impls;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.TestDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Test;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImp implements TestService {

    @Autowired
    TestDAO testDAO;


    @Override
    public Test findTestById(Integer idTest) {
        return testDAO.findTestByIdTest(idTest);
    }

    @Override
    public List<Test> findAllTest() {
        return testDAO.findAll();
    }

    @Override
    public Test createTest(Test test) {
        return testDAO.save(test);
    }
}

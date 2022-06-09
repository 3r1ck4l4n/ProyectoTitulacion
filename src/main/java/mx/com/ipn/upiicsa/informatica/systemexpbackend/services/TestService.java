package mx.com.ipn.upiicsa.informatica.systemexpbackend.services;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Test;

import java.util.List;

public interface TestService {
    Test findTestById(Integer idTest);

    List<Test> findAllTest();

    Test createTest(Test test);
}

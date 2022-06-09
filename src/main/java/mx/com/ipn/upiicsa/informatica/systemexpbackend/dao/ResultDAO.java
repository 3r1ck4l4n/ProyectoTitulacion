package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.sql.Date;

public interface ResultDAO extends JpaRepository<Result, Integer> {

    public Long countResultsByCreatedAt(Date dateInitial);

    public Long countResultByResultTestLessThanEqual(BigDecimal bigDecimal);

    public Long countResultByResultTestGreaterThan(BigDecimal resultTest);
}

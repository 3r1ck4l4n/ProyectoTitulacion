package mx.com.ipn.upiicsa.informatica.systemexpbackend.services.impls;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.ResultDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.UserDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.HistoricalDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.ResultDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.StatisticsResultDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Result;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.ResultService;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.util.CertainFactorCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ResultServiceImp implements ResultService {

    private final Logger logger = LoggerFactory.getLogger(ResultServiceImp.class);

    @Autowired
    private CertainFactorCalculator certainFactorCalculator;

    @Autowired
    private ResultDAO resultDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public BigDecimal calculateCF(ResultDto resultDto){
        AtomicReference<BigDecimal> x = new AtomicReference<>(new BigDecimal(0));
        AtomicReference<BigDecimal> y = new AtomicReference<>(new BigDecimal(0));
        resultDto.getAnswers().forEach((key, value) ->{

            if(x.get().equals(new BigDecimal(0))){
                x.set(value);
                logger.info(x.toString());
            }
            else {
                y.set(value);
                logger.info(y.toString());

                if((x.get().compareTo(new BigDecimal(0)) < 0) && (y.get().compareTo(new BigDecimal(0)) < 0)){
                    x.set(certainFactorCalculator.valuesLessThanZero(x.get(), y.get()));
                    logger.info("values is negative: " +x.get().toString());
                }else if ((x.get().compareTo(new BigDecimal(0)) > 0) && (y.get().compareTo(new BigDecimal(0)) > 0)){
                    x.set(certainFactorCalculator.valuesGreaterThanZero(x.get(), y.get()));
                    logger.info("values is positive: " + x.get().toString());
                }else if(x.get().multiply(y.get()).compareTo(new BigDecimal(0)) <=0 ){
                    x.set(certainFactorCalculator.resultProductOfValuesLessOrEqualToZero(x.get(), y.get()));
                    logger.info("one value is negative "+ x.get().toString());
                }
            }
        });
        return x.get();
    }

    @Override
    public Result createResult(Result result) {



        return resultDAO.save(result);
    }

    @Override
    public StatisticsResultDto getStatisticsResult() {
        BigDecimal decimal =new BigDecimal("0.4") ;
        StatisticsResultDto statisticsResultDto = new StatisticsResultDto();
        statisticsResultDto.setCountUser( userDAO.count());
        statisticsResultDto.setCertainFactorGreater(resultDAO.countResultByResultTestGreaterThan(decimal));
        statisticsResultDto.setCertainFactorLess(resultDAO.countResultByResultTestLessThanEqual(decimal));
        return statisticsResultDto;
    }

}

package mx.com.ipn.upiicsa.informatica.systemexpbackend.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;


@Component
public class CertainFactorCalculator {
    Logger logger = LoggerFactory.getLogger(CertainFactorCalculator.class);

    public BigDecimal valuesGreaterThanZero(BigDecimal x, BigDecimal y){
        BigDecimal result = x.add(y.multiply(new BigDecimal(1).subtract(x)));
        return result;
    }

    public BigDecimal resultProductOfValuesLessOrEqualToZero(BigDecimal x, BigDecimal y){
        BigDecimal result = (x.add(y)).divide(new BigDecimal(1).subtract(x.abs().min(y.abs())), MathContext.DECIMAL128);
        return result;
    }

    public BigDecimal valuesLessThanZero(BigDecimal x, BigDecimal y){
        BigDecimal result = x.add(y.multiply(new BigDecimal(1).add(x)));
        return result;
    }
}

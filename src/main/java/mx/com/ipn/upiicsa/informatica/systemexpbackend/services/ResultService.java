package mx.com.ipn.upiicsa.informatica.systemexpbackend.services;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.ResultDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.StatisticsResultDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Result;

import java.math.BigDecimal;
import java.util.List;

public interface ResultService {

    public BigDecimal calculateCF(ResultDto resultDto);

    Result createResult (Result result);

    public StatisticsResultDto getStatisticsResult();

}

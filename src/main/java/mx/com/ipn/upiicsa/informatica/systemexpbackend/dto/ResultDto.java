package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultDto {

    @Getter
    @Setter
    private Integer idUser;

    @Getter
    @Setter
    private Integer idTest;

    @Getter
    @Setter
    private Map<String, BigDecimal> answers;
}

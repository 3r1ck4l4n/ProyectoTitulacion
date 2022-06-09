package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsResultDto {

    @Getter
    @Setter
    private Long certainFactorGreater;

    @Getter
    @Setter
    private Long certainFactorLess;

    @Getter
    @Setter
    private Long countUser;
}

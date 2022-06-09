package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponseDto {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private BigDecimal result;
}

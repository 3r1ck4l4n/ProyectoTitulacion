package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalDto {

    @Getter
    @Setter
    private Date dateRegister;

    @Getter
    @Setter
    private Long countRegister;

    @Getter
    @Setter
    private Long counterResults;
}

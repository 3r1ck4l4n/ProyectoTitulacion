package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;


import lombok.*;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Result;

import java.util.List;

@Data
@NoArgsConstructor
public class ProfileDto {
    public ProfileDto(String email, String name, String numProf) {
        this.email = email;
        this.name = name;
        this.numProf = numProf;
    }

    public ProfileDto(String email, String name, List<Result> resultList) {
        this.email = email;
        this.name = name;
        this.resultList = resultList;
    }

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String numProf;

    @Getter
    @Setter
    private List<Result> resultList;
}

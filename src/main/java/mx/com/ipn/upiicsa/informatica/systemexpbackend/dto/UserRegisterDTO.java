package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String numProf;
}

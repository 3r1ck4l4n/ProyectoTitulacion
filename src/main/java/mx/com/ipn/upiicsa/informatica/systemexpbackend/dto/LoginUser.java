package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;
}

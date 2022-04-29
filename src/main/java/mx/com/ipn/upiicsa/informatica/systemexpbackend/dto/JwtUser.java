package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public class JwtUser {
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String role;
}

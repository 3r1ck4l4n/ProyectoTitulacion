package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSession implements Serializable {

    public UserSession(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserSession(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

}

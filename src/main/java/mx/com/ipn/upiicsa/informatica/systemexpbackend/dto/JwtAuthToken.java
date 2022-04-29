package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthToken extends UsernamePasswordAuthenticationToken {

    @Getter
    @Setter
    private String token;

    public JwtAuthToken(String token) {
        super(null, null);
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}

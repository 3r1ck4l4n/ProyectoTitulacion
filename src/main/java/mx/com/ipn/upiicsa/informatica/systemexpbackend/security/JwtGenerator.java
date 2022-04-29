package mx.com.ipn.upiicsa.informatica.systemexpbackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.constants.Constants;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
        claims.put(Constants.ROLE, jwtUser.getRole());

        return Jwts.builder().setClaims(claims).
                signWith(SignatureAlgorithm.HS256, Constants.SECRET)
                .compact();

    }
}

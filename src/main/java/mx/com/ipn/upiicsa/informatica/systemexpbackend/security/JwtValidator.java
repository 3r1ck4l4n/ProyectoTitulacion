package mx.com.ipn.upiicsa.informatica.systemexpbackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.constants.Constants;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private Logger logger = LoggerFactory.getLogger(JwtValidator.class);

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        logger.info("This");
        try {
            Claims body = Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(token).getBody();
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Integer.parseInt((String) body.get(Constants.USER_ID)));
            jwtUser.setRole((String) body.get(Constants.ROLE));
            logger.info(jwtUser.getRole());
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return jwtUser;
    }

}

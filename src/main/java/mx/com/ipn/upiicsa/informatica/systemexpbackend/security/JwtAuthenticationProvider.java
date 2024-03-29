package mx.com.ipn.upiicsa.informatica.systemexpbackend.security;

import io.jsonwebtoken.ExpiredJwtException;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtAuthToken;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    Logger logger = LoggerFactory.getLogger(UserDetails.class);
    @Autowired
    private JwtValidator validator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException, ExpiredJwtException {

       JwtAuthToken jwtAuthToken = (JwtAuthToken) authentication;
       String token = jwtAuthToken.getToken();
       JwtUser jwtUser = validator.validate(token);
       if (jwtUser == null) throw new RuntimeException();
       List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
       return new JwtUserDetails(jwtUser.getUserName(), token, jwtUser.getId(), grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthToken.class.isAssignableFrom(authentication));
    }
}

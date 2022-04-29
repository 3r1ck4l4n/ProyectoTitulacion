package mx.com.ipn.upiicsa.informatica.systemexpbackend.security;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.constants.Constants;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtAuthToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.yaml.snakeyaml.scanner.Constant;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthTokenFilter extends AbstractAuthenticationProcessingFilter {

    //Recursos protegidos
    public JwtAuthTokenFilter() {
        super("/api/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        //Extraer el valor de Autenticación del header.
        String header = request.getHeader(Constants.AUTHORIZATION_HEADER);
        logger.info(header);
        //Verificar que el token existe
        if(header == null || !header.startsWith(Constants.BEARER_TOKEN))throw new RuntimeException("JWT is incorrect or no exist");
        //Se extrae el "Bearer " del token
        String authToken = header.substring(7);
        //Se instancia un objeto de JwtAuthToken y se envia el token
        JwtAuthToken jwtAuthToken = new JwtAuthToken(authToken);
        return getAuthenticationManager().authenticate(jwtAuthToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }


}

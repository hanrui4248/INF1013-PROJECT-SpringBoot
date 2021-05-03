package INF1013Group7.INF1013projetserveur.jwtFilter;

import INF1013Group7.INF1013projetserveur.dto.UserIntervenantDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {

            UserIntervenantDTO credentialDTO = new ObjectMapper()
                    .readValue(request.getInputStream(),
                            UserIntervenantDTO.class);

            Authentication auth = new UsernamePasswordAuthenticationToken(
                    credentialDTO.getUsername(), credentialDTO.getPassword());
            authenticationManager.authenticate(auth);// check si un et pw match

            return auth;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 300);

        String token = JWT.create()
                .withSubject(authResult.getName())
                .withIssuer("INF1013-PROJET")
                //.withArrayClaim("authorities", authResult.getAuthorities().toArray(new String[]{}))
                .withIssuedAt(new Date())
                .withExpiresAt(cal.getTime())
                .sign(Algorithm.HMAC256("TRETRETRETRETRTRETRE TRETRETRETRETRTRETRE TRETRETRETRETRTRETRE complexe"));

        response.addHeader("Authorization", "Bearer " + token);

    }
}

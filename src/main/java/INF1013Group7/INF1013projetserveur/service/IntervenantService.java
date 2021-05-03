package INF1013Group7.INF1013projetserveur.service;

import INF1013Group7.INF1013projetserveur.model.Individu;
import INF1013Group7.INF1013projetserveur.model.Intervenant;
import INF1013Group7.INF1013projetserveur.repository.IntervenantRepos;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service("authenticator")
public class IntervenantService implements UserDetailsService {
    private IntervenantRepos intervenantRepos;
    private PasswordEncoder passwordEncoder;

    public IntervenantService(IntervenantRepos intervenantRepos, PasswordEncoder passwordEncoder) {
        this.intervenantRepos = intervenantRepos;
        this.passwordEncoder = passwordEncoder;
    }
    public Optional<Intervenant> getIntervenant(Long id) {

        return intervenantRepos.findById(id);
    }




    public void deleteIntervenant(Long id){
        intervenantRepos.deleteById(id);
    }

    public List<Intervenant> getAllIntervenants() {
        return StreamSupport
                .stream(intervenantRepos.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void saveIntervenant(Intervenant intervenant) {
        intervenant.setMotDePasse(passwordEncoder.encode(intervenant.getMotDePasse()));
        this.intervenantRepos.save(intervenant);

    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Intervenant> optionalIntervenant = intervenantRepos.findByEmail(email);
        Intervenant intervenant = optionalIntervenant
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s non trouvé", email)));

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return intervenant.getMotDePasse();
            }

            @Override
            public String getUsername() {
                return intervenant.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }


}

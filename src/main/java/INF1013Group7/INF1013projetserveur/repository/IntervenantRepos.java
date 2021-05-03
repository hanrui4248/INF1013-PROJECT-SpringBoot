package INF1013Group7.INF1013projetserveur.repository;

import INF1013Group7.INF1013projetserveur.model.Intervenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntervenantRepos extends CrudRepository<Intervenant, Long> {
    Optional<Intervenant> findByEmail(String email);
}

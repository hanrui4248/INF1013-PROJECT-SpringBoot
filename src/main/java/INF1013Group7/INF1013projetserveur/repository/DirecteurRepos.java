package INF1013Group7.INF1013projetserveur.repository;

import INF1013Group7.INF1013projetserveur.model.Directeur;
import INF1013Group7.INF1013projetserveur.model.Individu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirecteurRepos extends CrudRepository<Directeur, Long> {
}

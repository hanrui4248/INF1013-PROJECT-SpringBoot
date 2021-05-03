package INF1013Group7.INF1013projetserveur.service;

import INF1013Group7.INF1013projetserveur.model.Directeur;
import INF1013Group7.INF1013projetserveur.model.Individu;
import INF1013Group7.INF1013projetserveur.repository.DirecteurRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DirecteurService {
    private DirecteurRepos directeurRepos;

    public DirecteurService(DirecteurRepos directeurRepos) {
        this.directeurRepos = directeurRepos;
    }


    public Optional<Directeur> getDirecteur(Long id) {

        return directeurRepos.findById(id);


    }


    //enregistrement ou mise a jour !!!
    public void saveDirecteur(Directeur directeur){
        directeurRepos.save(directeur);
    }


    public void deleteDirecteur(Directeur directeur){
        directeurRepos.delete(directeur);
    }

    public List<Directeur> getAllDirecteur() {
        return StreamSupport
                .stream(directeurRepos.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}

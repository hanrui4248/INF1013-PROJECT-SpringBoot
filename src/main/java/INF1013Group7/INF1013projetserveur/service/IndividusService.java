package INF1013Group7.INF1013projetserveur.service;

import INF1013Group7.INF1013projetserveur.model.Individu;
import INF1013Group7.INF1013projetserveur.repository.IndividuRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class IndividusService {
    private IndividuRepos individuRepos;
    public IndividusService(IndividuRepos individuRepos) {
        this.individuRepos = individuRepos;
    }



    public Optional<Individu> getIndividu(Long id) {

        return individuRepos.findById(id);


    }


    //enregistrement ou mise a jour !!!
    public void saveIndividu(Individu individu){
        individuRepos.save(individu);
    }


    public void deleteIndividu(Long id){
        individuRepos.deleteById(id);
    }

    public List<Individu> getAllIndividus() {

        return StreamSupport
                .stream(individuRepos.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


}

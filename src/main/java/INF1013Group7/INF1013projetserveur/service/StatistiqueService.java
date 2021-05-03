package INF1013Group7.INF1013projetserveur.service;

import INF1013Group7.INF1013projetserveur.model.Directeur;
import INF1013Group7.INF1013projetserveur.model.Statistique;
import INF1013Group7.INF1013projetserveur.repository.StatistiqueRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatistiqueService {
    private StatistiqueRepos statistiqueRepos;

    public StatistiqueService(StatistiqueRepos statistiqueRepos) {
        this.statistiqueRepos = statistiqueRepos;
    }

    public Optional<Statistique> getStatistique(Long id) {

        return statistiqueRepos.findById(id);


    }


    //enregistrement ou mise a jour !!!
    public void saveStatistique(Statistique statistique){
        statistiqueRepos.save(statistique);
    }


    public void deleteStatistique(Statistique statistique){
        statistiqueRepos.delete(statistique);
    }

    public List<Statistique> getAllStatistique() {
        return StreamSupport
                .stream(statistiqueRepos.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}

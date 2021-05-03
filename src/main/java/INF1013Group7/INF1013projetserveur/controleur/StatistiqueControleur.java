package INF1013Group7.INF1013projetserveur.controleur;


import INF1013Group7.INF1013projetserveur.model.Statistique;
import INF1013Group7.INF1013projetserveur.service.StatistiqueService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/statistique")
@Api(value = "ActControllerAPI",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class StatistiqueControleur {
    private final StatistiqueService statistiqueService;
    public StatistiqueControleur(StatistiqueService statistiqueService) {
        this.statistiqueService = statistiqueService;
    }

    @GetMapping(path = "/getAll/")
    public List<Statistique> getAllStatistiques(){
        List<Statistique> statistiques = statistiqueService.getAllStatistique();
        return statistiques;
    }

    @GetMapping(path = "/get/{id}")
    public Statistique getStatistique(@PathVariable("id") Long id){
        Optional<Statistique> statistique = statistiqueService.getStatistique(id);
        return statistique.orElseThrow(()->new RuntimeException("Étudiant non trouvé"));
    }
    @PostMapping(path = "/add")
    public void addStatistique( @RequestBody Statistique statistique){
        statistiqueService.saveStatistique(statistique);
    }


    @DeleteMapping(path = "/delete")
    public void deleteStatistique( @RequestBody Statistique statistique){
        statistiqueService.deleteStatistique(statistique);
    }
}

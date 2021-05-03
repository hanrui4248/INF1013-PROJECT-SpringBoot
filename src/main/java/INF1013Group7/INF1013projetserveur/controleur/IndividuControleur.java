package INF1013Group7.INF1013projetserveur.controleur;


import INF1013Group7.INF1013projetserveur.model.Individu;
import INF1013Group7.INF1013projetserveur.service.IndividusService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/indivudu")
@Api(value = "ActControllerAPI",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class IndividuControleur {
    private final IndividusService individusService;
    public IndividuControleur(IndividusService individusService) {
        this.individusService = individusService;
    }

    @GetMapping(path = "/getAll/")
    public List<Individu> getAllIndividus(){
        List<Individu> individus = individusService.getAllIndividus();
        return individus;
    }

    @GetMapping(path = "/get/{id}")
    public Individu getIndividu(@PathVariable("id") Long id){
        Optional<Individu> individu = individusService.getIndividu(id);

        return individu.orElseThrow(()->new RuntimeException("Étudiant non trouvé"));
    }


    @PostMapping(path = "/add")
    public void addIndividu( @RequestBody Individu individu){
        individusService.saveIndividu(individu);
    }


    @DeleteMapping(path = "/delete/{id}")
    public void deleteIndividu( @PathVariable("id") Long id){
        individusService.deleteIndividu(id);
    }

}

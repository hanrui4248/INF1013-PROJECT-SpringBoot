package INF1013Group7.INF1013projetserveur.controleur;


import INF1013Group7.INF1013projetserveur.model.Directeur;

import INF1013Group7.INF1013projetserveur.service.DirecteurService;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/directeur")
@Api(value = "ActControllerAPI",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class DirecteurControleur {
    private final DirecteurService directeurService;
    public DirecteurControleur(DirecteurService directeurService) {
        this.directeurService = directeurService;
    }

    @GetMapping(path = "/getAll/")
    public List<Directeur> getAllDirecteurs(){
        List<Directeur> directeurs = directeurService.getAllDirecteur();
        return directeurs;
    }

    @GetMapping(path = "/get/{id}")
    public Directeur getDirecteur(@PathVariable("id") Long id){
        Optional<Directeur> directeur = directeurService.getDirecteur(id);
        return directeur.orElseThrow(()->new RuntimeException("non trouvé"));
    }
    @PostMapping(path = "/add")
    public void addDirecteur( @RequestBody Directeur directeur){
        directeurService.saveDirecteur(directeur);
    }

    @PostMapping(path = "/signup")
    public void directeurSignup( @RequestBody Directeur directeur){
        directeurService.saveDirecteur(directeur);
    }


    @DeleteMapping(path = "/delete")
    public void deleteDirecteur( @RequestBody Directeur directeur){
        directeurService.deleteDirecteur(directeur);
    }
}

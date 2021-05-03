package INF1013Group7.INF1013projetserveur.controleur;



import INF1013Group7.INF1013projetserveur.model.Intervenant;


import INF1013Group7.INF1013projetserveur.service.IntervenantService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/intervenant")
@Api(value = "ActControllerAPI",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class IntervenantControleur {
    private final IntervenantService intervenantService;


    @Autowired
    private JavaMailSender mailSender;

    public IntervenantControleur(IntervenantService intervenantService) {
        this.intervenantService = intervenantService;
    }

    @GetMapping(path = "/getAll/")
    public List<Intervenant> getAllIntervenants(){
        List<Intervenant> intervenants = intervenantService.getAllIntervenants();
        return intervenants;
    }

    @GetMapping(path = "/get/{id}")
    public Intervenant getIntervenant(@PathVariable("id") Long id){
        Optional<Intervenant> intervenant = intervenantService.getIntervenant(id);
        return intervenant.orElseThrow(()->new RuntimeException(" non trouvé"));
    }
    @PostMapping(path = "/add")
    public void addIntervenant( @RequestBody Intervenant intervenant){
        intervenantService.saveIntervenant(intervenant);
    }

    @PostMapping(path = "/signup")
    public void intervenantSignup( @RequestBody Intervenant intervenant){
        intervenantService.saveIntervenant(intervenant);
        sendEmail(intervenant);
    }


    @DeleteMapping(path = "/delete/{id}")
    public void deleteIntervenant( @PathVariable("id") Long id){
        intervenantService.deleteIntervenant(id);
    }


    private void sendEmail(Intervenant intervenant){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("78015668hhr@gmail.com");

        msg.setSubject("inscription réussie");
        msg.setText("inscription réussie");

        mailSender.send(msg);

    }


}

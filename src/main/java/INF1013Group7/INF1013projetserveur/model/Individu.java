package INF1013Group7.INF1013projetserveur.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "individu")
@Data//lombock
public class Individu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;
    private int age;
    private String sexe;
    private String adresse;
    private String tel;
    private String NAS;
    private String departement;
    private String suivi;
    private String notesEvolutive;
    private String objectif;



}



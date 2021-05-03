package INF1013Group7.INF1013projetserveur.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "statistique")
@Data//lombock
public class Statistique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nbHeureTravailehebdomadaire;
    private int nbHeureTravaileMensuel;
    private int nbHeureTravailleAnnuel;
}


package INF1013Group7.INF1013projetserveur.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "intervenant")
@Data//lombock
public class Intervenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;
    private String email;
    private String tel;
    private String adresse;
    private String motDePasse;
}


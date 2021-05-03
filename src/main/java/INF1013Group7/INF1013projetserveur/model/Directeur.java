package INF1013Group7.INF1013projetserveur.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "directeur")
@Data//lombock
public class Directeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String motDePasse;
}

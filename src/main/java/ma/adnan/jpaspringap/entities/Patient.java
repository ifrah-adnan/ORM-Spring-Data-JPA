package ma.adnan.jpaspringap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Data @NoArgsConstructor @AllArgsConstructor
@Entity

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
     private boolean malade ;
     private int score;
}

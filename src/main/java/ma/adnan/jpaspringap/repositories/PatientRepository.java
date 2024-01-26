package ma.adnan.jpaspringap.repositories;

import ma.adnan.jpaspringap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade(boolean malade);
     Page<Patient> findByMalade(boolean malade, Pageable pageable);
 List<Patient> findByMaladeAndScoreLessThan(boolean malade,int score);
List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOOrNomLike(Date d1, Date d2,String mc);
@Query("select p from  Patient p where p.dateNaissance between :d1 and :d2 or p.nom like :n")
List<Patient> chercherPatient(@Param("d1")Date d1,@Param("d2") Date d2,@Param("n") String nom);

}

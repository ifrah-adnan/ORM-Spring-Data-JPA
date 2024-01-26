package ma.adnan.jpaspringap;

import ma.adnan.jpaspringap.entities.Patient;
import ma.adnan.jpaspringap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class JpaSpringApApplication implements CommandLineRunner {
   @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaSpringApApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {


        patientRepository.save(
                new Patient(null,"ifrah",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100))
        );}
   Page<Patient>patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("total of pages "+patients.getTotalPages());
        System.out.println("total of pages "+patients.getNumber());
        List<Patient> content=patients.getContent();
        Page<Patient> byMalade = patientRepository.findByMalade(true,PageRequest.of(0,6));
        List<Patient> byMaladeAndScoreLessThan = patientRepository.findByMaladeAndScoreLessThan(true, 30);
        byMaladeAndScoreLessThan.forEach(p->{
    System.out.println("___________________");
    System.out.println(p.getId());
    System.out.println(p.getNom());
    System.out.println(p.getScore());
    System.out.println(p.isMalade());

});
        System.out.println("--------------------------");
Patient patient=patientRepository.findById(1L).orElseThrow(()->new RuntimeException("Patient Not found"));
if(patient!=null){
    System.out.println(patient.getNom());
    System.out.println(patient.getDateNaissance());
}
patient.setScore(3111);
patientRepository.save(patient);




    }
}

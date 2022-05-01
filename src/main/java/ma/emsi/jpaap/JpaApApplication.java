package ma.emsi.jpaap;

import ma.emsi.jpaap.entities.Patient;
import ma.emsi.jpaap.repositories.PatientRepository;
import ma.emsi.jpaap.sec.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class JpaApApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);

    }
    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
   //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
         /* patientRepository.save(new Patient(null,"abdo",new Date(),false,155));
            patientRepository.save(new Patient(null,"youssef",new Date(),true,190));
            patientRepository.save(new Patient(null,"mohammed",new Date(),false,122));
          patientRepository.save(new Patient(null,"saad",new Date(),true,155));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            })*/
        };
    }
   @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
         securityService.saveNewUser("saad","1234","1234");
            securityService.saveNewUser("ali","1234","1234");

           securityService.saveNewRole("USER","");
           securityService.saveNewRole("ADMIN","");

           securityService.addRoleToUser("saad","ADMIN");
           securityService.addRoleToUser("saad","USER");
           securityService.addRoleToUser("ali","USER");

        };
    }

}

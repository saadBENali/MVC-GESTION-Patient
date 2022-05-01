package ma.emsi.jpaap.repositories;


import ma.emsi.jpaap.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long>{
    Medecin findByNom(String name);
    Page<Medecin> findByNomContains(String kw, Pageable pageable);
}

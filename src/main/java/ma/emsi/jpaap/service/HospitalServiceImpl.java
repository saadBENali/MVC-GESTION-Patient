package ma.emsi.jpaap.service;

import ma.emsi.jpaap.entities.Consultation;
import ma.emsi.jpaap.entities.Patient;
import ma.emsi.jpaap.entities.RendezVous;
import ma.emsi.jpaap.repositories.ConsultationRepository;
import ma.emsi.jpaap.repositories.MedecinRepository;
import ma.emsi.jpaap.repositories.PatientRepository;
import ma.emsi.jpaap.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
   private PatientRepository patientRepository;
   private MedecinRepository medecinRepository;
   private RendezVousRepository rendezVousRepository;
   private ConsultationRepository consultationRepository;


    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public Patient saveMedecin(Patient patient) {
        return patientRepository.save(patient);
    }


    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}

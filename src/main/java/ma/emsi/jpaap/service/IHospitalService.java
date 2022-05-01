package ma.emsi.jpaap.service;

import ma.emsi.jpaap.entities.Consultation;
import ma.emsi.jpaap.entities.Medecin;
import ma.emsi.jpaap.entities.Patient;
import ma.emsi.jpaap.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);


    Patient saveMedecin(Patient patient);

    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}

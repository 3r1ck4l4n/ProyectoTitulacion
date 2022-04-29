package mx.com.ipn.upiicsa.informatica.systemexpbackend.dao;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsychologistDAO extends JpaRepository<Psychologist, Integer> {
    public Psychologist findPsychologistByEmailPsychologist(String email);
}

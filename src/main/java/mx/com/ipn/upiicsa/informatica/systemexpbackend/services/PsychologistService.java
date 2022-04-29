package mx.com.ipn.upiicsa.informatica.systemexpbackend.services;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;

public interface PsychologistService {
    Psychologist createPsychologist(Psychologist psychologist);
    JwtUser existPsychologist(Psychologist psychologist);
}

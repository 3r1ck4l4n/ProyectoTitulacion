package mx.com.ipn.upiicsa.informatica.systemexpbackend.services;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.ProfileDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.UserRegisterDTO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.UserSession;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;

public interface PsychologistService {
    Psychologist createPsychologist(UserRegisterDTO psychologist);

    JwtUser existPsychologist(Psychologist psychologist);

    UserSession getPsychologist(Integer idPsychologist);

    ProfileDto getInfoProfile(Integer id);
}

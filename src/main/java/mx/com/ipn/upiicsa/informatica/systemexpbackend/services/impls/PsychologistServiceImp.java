package mx.com.ipn.upiicsa.informatica.systemexpbackend.services.impls;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.PsychologistDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.ProfileDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.UserRegisterDTO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.UserSession;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.PsychologistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class PsychologistServiceImp implements PsychologistService {

    private final Logger logger = LoggerFactory.getLogger(PsychologistServiceImp.class);
    private final Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);

    @Autowired
    private PsychologistDAO psychologistDAO;

    @Override
    public Psychologist createPsychologist(UserRegisterDTO userRegisterDTO ) {
        Psychologist psychologist = new Psychologist(userRegisterDTO.getEmail(),userRegisterDTO.getPassword(), userRegisterDTO.getUsername(), userRegisterDTO.getNumProf());
        String passHash = argon2.hash(1, 1024, 1, psychologist.getPasswordPsychologist());
        psychologist.setPasswordPsychologist(passHash);
        try {
            return psychologistDAO.save(psychologist);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicate entry " + psychologist.getEmailPsychologist() + " for key 'EMAIL_USER'");
            }
    }

    @Override
    public JwtUser existPsychologist(Psychologist psychologist) {
        String  pass = psychologist.getPasswordPsychologist();
        try {
            Psychologist psychologistInDB = psychologistDAO.findPsychologistByEmailPsychologist(psychologist.getEmailPsychologist());
            if (argon2.verify(psychologistInDB.getPasswordPsychologist(),pass)){
                return new JwtUser(psychologistInDB.getNamePsychologist(),psychologistInDB.getIdPsychologist(),"ROLE_PSYCHOLOGIST");
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login data is incorrect");
        }catch (Exception e){
            logger.info("Psychologist not found");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login data is incorrect");
        }
    }

    @Override
    public UserSession getPsychologist(Integer idPsychologist) {
        Psychologist psychologist = psychologistDAO.findById(idPsychologist).get();
        return new UserSession(psychologist.getIdPsychologist(),psychologist.getNamePsychologist(), psychologist.getEmailPsychologist()) ;
    }

    @Override
    public ProfileDto getInfoProfile(Integer id) {
        Optional<Psychologist> psychologist = psychologistDAO.findById(id);
        if (!psychologist.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found");
        return new ProfileDto(psychologist.get().getEmailPsychologist(),psychologist.get().getNamePsychologist(),psychologist.get().getNumberProf());
    }
}

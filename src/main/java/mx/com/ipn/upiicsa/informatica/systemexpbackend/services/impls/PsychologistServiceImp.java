package mx.com.ipn.upiicsa.informatica.systemexpbackend.services.impls;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.PsychologistDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.PsychologistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PsychologistServiceImp implements PsychologistService {

    private Logger logger = LoggerFactory.getLogger(PsychologistServiceImp.class);
    private Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);

    @Autowired
    private PsychologistDAO psychologistDAO;

    @Override
    public Psychologist createPsychologist(Psychologist psychologist) {
        String passHash = argon2.hash(1, 1024, 1, psychologist.getPasswordPsychologist());
        psychologist.setPasswordPsychologist(passHash);
        try {
            return psychologistDAO.save(psychologist);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Duplicate entry " + psychologist.getEmailPsychologist() + " for key 'EMAIL_USER'"));
        }
    }

    @Override
    public JwtUser existPsychologist(Psychologist psychologist) {
        String  pass = psychologist.getPasswordPsychologist();
        try {
            Psychologist psychologistInDB = psychologistDAO.findPsychologistByEmailPsychologist(psychologist.getEmailPsychologist());
            if (argon2.verify(psychologistInDB.getPasswordPsychologist(),pass)){
                JwtUser jwtUser = new JwtUser(psychologistInDB.getNamePsychologist(),psychologistInDB.getIdPsychologist(),"ROLE_PSYCHOLOGIST");
                return jwtUser;
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, String.format("Login data is incorrect"));
        }catch (Exception e){
            logger.info("Psychologist not found");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, String.format("Login data is incorrect"));
        }
    }
}

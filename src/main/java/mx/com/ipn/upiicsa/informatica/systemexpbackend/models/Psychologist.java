package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "psychologists")
public class Psychologist {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_psychologist")
    private Integer idPsychologist;

    @Getter
    @Setter
    @Column(name = "email_psychologist")
    private String emailPsychologist;

    @Getter
    @Setter
    @Column(name = "password_psychologist")
    private String passwordPsychologist;

    @Getter
    @Setter
    @Column(name = "name_psychologist")
    private String namePsychologist;

    @Getter
    @Setter
    @Column(name = "number_professional_certificate")
    private String numberProf;

}

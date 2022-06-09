package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@ToString
@Entity
@Table(name = "psychologists")
@NoArgsConstructor
public class Psychologist {

    public Psychologist(String emailPsychologist, String passwordPsychologist) {
        this.emailPsychologist = emailPsychologist;
        this.passwordPsychologist = passwordPsychologist;
    }

    public Psychologist(String emailPsychologist, String passwordPsychologist, String namePsychologist, String numberProf) {
        this.emailPsychologist = emailPsychologist;
        this.passwordPsychologist = passwordPsychologist;
        this.namePsychologist = namePsychologist;
        this.numberProf = numberProf;
    }

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

    @Getter
    @Setter
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

}

package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    @Getter
    @Setter
    private Integer idUser;

    @Column(name = "EMAIL_USER")
    @Getter
    @Setter
    private String emailUser;

    @Column(name = "PASSWORD_USER")
    @Setter
    @Getter
    private String passwordUser;

    @Column(name = "NAME_USER")
    @Getter
    @Setter
    private String userName;

}

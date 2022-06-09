package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@ToString
@Entity
@Table(name = "Users")
@NoArgsConstructor
public class User {

    public User(String emailUser, String passwordUser, String userName) {
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.userName = userName;
    }

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

    @Getter
    @Setter
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_User")
    @Getter
    @Setter
    private List<Result> results;


}

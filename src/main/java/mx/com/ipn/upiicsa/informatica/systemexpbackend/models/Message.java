package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Integer idMessage;

    @Getter
    @Setter
    @Column(name = "message_statement")
    private String messageStatement;

    @Getter
    @Setter
    @Column(name = "id_psychologist")
    private Integer idPsychologist;

    @Getter
    @Setter
    @Column(name = "id_user")
    private Integer idUser;

    @Getter
    @Setter
    @Column(name = "user_send")
    private boolean userSend;
}

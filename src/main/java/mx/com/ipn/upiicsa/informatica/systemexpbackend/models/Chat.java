package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.Getter;
import lombok.Setter;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.keys.ChatKeys;

import javax.persistence.*;

@Entity
@Table(name = "chats")
@IdClass(ChatKeys.class)
public class Chat{
    @Id
    @Getter
    @Setter
    @Column(name = "id_user")
    private Integer idUser;

    @Id
    @Getter
    @Setter
    @Column(name = "id_psychologist")
    private Integer idPsychologist;
}

package mx.com.ipn.upiicsa.informatica.systemexpbackend.models.keys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class ChatKeys implements Serializable {
    @Getter
    @Setter
    private Integer idUser;
    private Integer idPsychologist;

}


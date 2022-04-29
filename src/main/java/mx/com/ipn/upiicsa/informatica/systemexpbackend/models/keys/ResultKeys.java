package mx.com.ipn.upiicsa.informatica.systemexpbackend.models.keys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
public class ResultKeys implements Serializable {
    public ResultKeys(){

    }

    @Getter
    @Setter
    @Column(name = "id_user")
    private Integer idUser;

    @Getter
    @Setter
    @Column(name = "id_test")
    private Integer idTest;
}

package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.keys.ResultKeys;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "results")
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @EmbeddedId
    @Getter
    @Setter
    private ResultKeys resultKeys;

    @Getter
    @Setter
    @Column(name = "result_test")
    private BigDecimal resultTest;

    @Getter
    @Setter
    @Column(name = "feedback")
    private String feedback;
}

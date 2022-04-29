package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer")
    @Getter
    @Setter
    private Integer idAnswer;

    @Getter
    @Setter
    @Column(name = "answer_statement")
    private String answerStatement;

    @Getter
    @Setter
    @Column(name = "certain_factor")
    private BigDecimal certainFactor;

    @Getter
    @Setter
    @Column(name = "idQuestion")
    private Integer idQuestion;
}

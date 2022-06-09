package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {

    public Answer(String answerStatement, BigDecimal certainFactor) {
        this.answerStatement = answerStatement;
        this.certainFactor = certainFactor;
    }

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

    @JsonBackReference(value = "Question-Answer")
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;
}

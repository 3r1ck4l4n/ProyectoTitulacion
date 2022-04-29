package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_question")
    private Integer idQuestion;

    @Getter
    @Setter
    @Column(name = "question_statement")
    private String questionStatement;

    @Getter
    @Setter
    @Column(name = "id_test")
    private Integer idTest;
}

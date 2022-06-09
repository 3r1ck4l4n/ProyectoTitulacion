package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@NoArgsConstructor
public class Question {

    public Question(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public Question(String questionStatement, List<Answer> answers) {
        this.questionStatement = questionStatement;
        this.answers = answers;
    }

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

    @JsonManagedReference(value = "Question-Answer")
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answers;

    @JsonBackReference(value = "Test-Question")
    @Setter
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_test")
    private Test test;
}

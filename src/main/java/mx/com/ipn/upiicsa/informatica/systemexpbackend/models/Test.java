package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "tests")
public class Test {

    public Test(String nameTest, String descriptionTest) {
        this.nameTest = nameTest;
        this.descriptionTest = descriptionTest;
    }

    public Test(String nameTest, String descriptionTest, List<Result> results, List<Question> questions) {
        this.nameTest = nameTest;
        this.descriptionTest = descriptionTest;
        this.results = results;
        this.questions = questions;
    }

    @Id
    @Column(name = "id_test")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer idTest;

    @Column(name = "name_test")
    @Getter
    @Setter
    private String nameTest;


    @Column(name = "description_test")
    @Getter
    @Setter
    private String descriptionTest;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test")
    private List<Result> results;

    @JsonManagedReference(value = "Test-Question")
    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "test")
    private List<Question> questions;
}

package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tests")
class Test {


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
}

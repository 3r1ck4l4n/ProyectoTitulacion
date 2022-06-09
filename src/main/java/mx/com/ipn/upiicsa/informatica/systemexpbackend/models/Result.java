package mx.com.ipn.upiicsa.informatica.systemexpbackend.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "results")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {
    public Result(Integer idUser, Integer idTest, BigDecimal resultTest, String feedback) {
        this.idUser = idUser;
        this.idTest = idTest;
        this.resultTest = resultTest;
        this.feedback = feedback;
    }

    @Id
    @Column(name = "id_result")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Integer idResult;

    @Getter
    @Setter
    @Column(name = "id_user")
    private Integer idUser;

    @Getter
    @Setter
    @Column(name = "id_test")
    private Integer idTest;

    @Getter
    @Setter
    @Column(name = "result_test")
    private BigDecimal resultTest;

    @Getter
    @Setter
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Getter
    @Setter
    @Column(name = "feedback")
    private String feedback;



}

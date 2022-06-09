package mx.com.ipn.upiicsa.informatica.systemexpbackend.dto;

import lombok.*;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Result;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    @Getter
    @Setter
    private String emailUser;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private Date createdAt;

    @Getter
    @Setter
    private List<Result> results;
}

package HRComponents.Entitys;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
@Entity
@Builder
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "isactivated")
    private boolean isActivated;

}

package HRComponents.Entitys;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
@Entity
@Builder
public class Users {
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Privilege_id", referencedColumnName = "Privilege_Role_id", insertable = false, updatable = false)
    private SystemUser SystemUser;

}

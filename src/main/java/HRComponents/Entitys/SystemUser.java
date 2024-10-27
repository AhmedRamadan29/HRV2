package HRComponents.Entitys;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@Table(name="system_users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id") private int id;
    @Column(name="role") private String role;
    @Column(name="Privilege_Role_id", unique=true) private Integer PrivilegeRole;
}

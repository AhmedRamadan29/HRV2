package HRComponents.Entitys;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Table(name = "activation_panel_for_system_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ActivationPanelForSystemUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SystemUser.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "system_user")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SystemUser systemUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;
    @Column(name = "activation_date")
    private Date activationDate;
    @Column(name = "is_approved")
    private boolean isApproved;
    @Column(name = "detail")
    private String detail;
}

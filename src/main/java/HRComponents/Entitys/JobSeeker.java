package HRComponents.Entitys;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Table(name="job_seekers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobSeeker{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id") private int id;
    @Column(name="firstname") private String firstName;
    @Column(name="lastname") private String lastName;
    @Column(name="birthdate") private int birthDate;
    @Column(name="nationalityid") private long nationalityId;
    @Column(name="linkedin_account") private String linkedInAccount;
    @Column(name="github_account") private String githubAccount;
    @Column(name="info_about_job_seeker") private String info;
    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="emp_id", referencedColumnName="id") private Employer employer;
}

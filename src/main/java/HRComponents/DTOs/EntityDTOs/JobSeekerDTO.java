package HRComponents.DTOs.EntityDTOs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class JobSeekerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private long nationalityId;
    private String linkedInAccount;
    private String githubAccount;
    private String info;
}

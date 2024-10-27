package HRComponents.DTOs.CoustomJoinTablesDTOs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Builder
public class ReportGetAllInfoUserDTO{
    private String firstName;
    private String lastName;
    private int birthDate;
    private String position;
    private String githubAccount;
    private String linkedinAccount;
    private String email;
    private boolean status;
    private String createdDate;
    private String company;
    @JsonIgnore private String privilege;
    private String website;
    private String phoneNumber;
}

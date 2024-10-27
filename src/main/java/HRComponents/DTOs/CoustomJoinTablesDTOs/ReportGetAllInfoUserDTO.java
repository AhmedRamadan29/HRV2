package HRComponents.DTOs.CoustomJoinTablesDTOs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Builder
public class ReportGetAllInfoUserDTO{
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Integer age;
    private String nationalityId;
    private String position;
    private String githubAccount;
    private String linkedinAccount;
    private String email;
    private String status;
    private String createdDate;
    private String company;
    private String privilege;
    private String website;
    private String phoneNumber;
}

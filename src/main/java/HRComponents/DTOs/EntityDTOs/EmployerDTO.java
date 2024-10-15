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
public class EmployerDTO {
    private int id;
    private String companyName;
    private String phone;
    private String webSites;
}

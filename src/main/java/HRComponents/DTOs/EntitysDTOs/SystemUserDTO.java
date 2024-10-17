package HRComponents.DTOs.EntitysDTOs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class SystemUserDTO {
    private int id;
    private String role;
    private Integer PrivilegeRole;
}

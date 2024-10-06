package HRComponents.DTOs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class UserDTO {
    private int id;
    private String email;
    private String password;
    private Date createdDate;
    private boolean status;
    private boolean isActivated;

}
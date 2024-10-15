package HRComponents.DTOs.CoustomJoinTablesDTOs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class UsersJoinSystemUsersDTO {
    private String email;
    private Date createdDate;
    private String password;
    private boolean status;
    private boolean isActivated;
    private String role;
    public UsersJoinSystemUsersDTO(boolean activated, Date createdDate, boolean status, String role) {
        this.isActivated = activated; this.createdDate = createdDate; this.status = status;}
}


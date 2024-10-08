package HRComponents.DTOs.CoustomJoinTablesDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class UsersJoinSystemUsersDTO {
    private String email;
    private Date createdDate;
    private String password;
    private boolean status;
    private boolean isActivated;
    private String role;
}

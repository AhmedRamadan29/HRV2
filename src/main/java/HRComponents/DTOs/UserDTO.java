package HRComponents.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class UserDTO {

    private int id;
    @NotBlank(message = "email is mandatory")
    @NotNull(message = "Add email for user")
    private String email;
    @NotBlank(message = "password is mandatory")
    @NotNull(message = "Add password for user")
    private String password;
    @NotNull(message = "Add password for user")
    @PastOrPresent(message = "Publish CreatedDate must be in the past or present")
    private Date createdDate;
    private boolean status;
    private boolean isActivated;












}
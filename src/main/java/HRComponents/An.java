package HRComponents;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

 class An {
    @PastOrPresent(message = "Publish Date must be in the past or present")
    private Date date;
    @NotBlank(message = "email is mandatory")
    @NotNull(message = "Add email for user")
    private String email;

}

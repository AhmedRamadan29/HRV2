package HRComponents.Mapper;
import HRComponents.Entitys.User;
import HRComponents.DTOs.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDTO toDTO(User user) {
        return  UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .status(user.isStatus())
                .isActivated(user.isActivated())
                .build();

    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setStatus(userDTO.isStatus());
        user.setActivated(userDTO.isActivated());
        return user;
    }
}
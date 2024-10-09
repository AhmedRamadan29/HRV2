package HRComponents.Mapper.MapperEntitys;
import HRComponents.DTOs.EntityDTOs.UserDTO;
import HRComponents.Entitys.Users;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {
    /**
     * Converts a Users entity to a UserDTO.
     *
     * @param users the Users entity to be converted
     * @return a UserDTO object containing the data from the Users entity
     */
    public static UserDTO toDTO(Users users) {
        return UserDTO.builder().id(users.getId()).email(users.getEmail()).password(users.getPassword()).createdDate(users.getCreatedDate()).status(users.isStatus()).isActivated(users.isActivated()).build();
    }
    /**
     * Converts a UserDTO to a Users entity.
     *
     * @param userDTO the UserDTO to be converted
     * @return a Users entity containing the data from the UserDTO
     */
    public static Users toEntity(UserDTO userDTO) {
        return Users.builder().id(userDTO.getId()).email(userDTO.getEmail()).password(userDTO.getPassword()).createdDate(userDTO.getCreatedDate()).status(userDTO.isStatus()).isActivated(userDTO.isActivated()).build();
    }
}
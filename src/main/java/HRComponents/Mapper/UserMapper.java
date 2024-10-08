package HRComponents.Mapper;

import HRComponents.DTOs.EntityDTOs.UserDTO;
import HRComponents.Entitys.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDTO toDTO(Users users) {
        return UserDTO.builder().id(users.getId())
                .email(users.getEmail())
                .password(users.getPassword())
                .createdDate(users.getCreatedDate())
                .status(users.isStatus())
                .isActivated(users.isActivated()).build();
    }

    public static Users toEntity(UserDTO userDTO) {

        return Users.builder().id(userDTO.getId()).
                email(userDTO.getEmail()).password(userDTO.getPassword()).
                createdDate(userDTO.getCreatedDate()).status(userDTO.isStatus()).
                isActivated(userDTO.isActivated()).build();
    }
}
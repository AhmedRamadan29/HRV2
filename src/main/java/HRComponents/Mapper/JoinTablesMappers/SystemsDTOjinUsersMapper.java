package HRComponents.Mapper.JoinTablesMappers;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.Entitys.SystemUser;
import HRComponents.Entitys.Users;
import org.springframework.stereotype.Component;
@Component
public class SystemsDTOjinUsersMapper {
    public static UsersJoinSystemUsersDTO TODOSystemUsers(Users users, SystemUser systemUsers) {
        return UsersJoinSystemUsersDTO.builder().email(users.getEmail()).createdDate(users.getCreatedDate()).password(users.getPassword()).status(users.isStatus()).isActivated(users.isActivated()).role(systemUsers.getRole()).build();
    }
}

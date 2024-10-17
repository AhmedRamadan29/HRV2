package HRComponents.AbstractionImp.EntityManager.JoinTableEntityMangerImplementations;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import java.util.List;
public interface UsersJoinSystemUsersImplementations{
    List<UsersJoinSystemUsersDTO> findUsersWithRole(String roleName);
}

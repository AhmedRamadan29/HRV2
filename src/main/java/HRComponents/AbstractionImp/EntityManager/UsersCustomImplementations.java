package HRComponents.AbstractionImp.EntityManager;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;

import java.util.List;
public interface UsersCustomImplementations {
    List<UsersJoinSystemUsersDTO> findUsersWithRole(String roleName);
}

package HRComponents.AbstractionImp.EntityManager;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.DTOs.EntityDTOs.UserDTO;

import java.util.Hashtable;
import java.util.List;
public interface UsersCustomImplementations {
    List<UsersJoinSystemUsersDTO> findUsersWithRole(String roleName);
    void UpdateAll(Hashtable<Integer, UserDTO> userDTO);
}

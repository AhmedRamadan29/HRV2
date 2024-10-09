package HRComponents.AbstractionImp.CRUDImp;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.DTOs.EntityDTOs.UserDTO;

import java.util.List;
public interface CRUDUsersServiceMethod {
 List<UserDTO> getAll();
 List<UserDTO> create(List<UserDTO> tList);
 List<UsersJoinSystemUsersDTO> getPrivate(String PrivateName);
 List<UsersJoinSystemUsersDTO> getUserIsActive(String role);
}


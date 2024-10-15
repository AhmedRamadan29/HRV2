package HRComponents.AbstractionImp.CRUDImpService;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;

import java.util.List;
public interface UsersJoinSystemUsersMethod  {
    List<UsersJoinSystemUsersDTO> getPrivate(String PrivateName);
    List<UsersJoinSystemUsersDTO> getUserIsActive(String role);
}

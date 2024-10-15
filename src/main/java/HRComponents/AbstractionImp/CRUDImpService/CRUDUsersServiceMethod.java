package HRComponents.AbstractionImp.CRUDImpService;
import HRComponents.DTOs.EntityDTOs.UserDTO;
import java.util.Hashtable;
import java.util.List;
public interface CRUDUsersServiceMethod extends UsersJoinSystemUsersMethod {
    List<UserDTO> getAll();
    List<UserDTO> create(List<UserDTO> tList);
    Hashtable<Integer, UserDTO> UpdateUser( List<Integer> id, Hashtable <Integer , UserDTO> userDTO);
}


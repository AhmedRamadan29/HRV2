package HRComponents.AbstractionImp.EntityManager.SingleTableEntityManger;
import HRComponents.DTOs.EntitysDTOs.UserDTO;

import java.util.Hashtable;
public interface UsersImplementations{
    void UpdateAll(Hashtable<Integer,UserDTO> userDTO);
}

package HRComponents.AbstractionImp.EntityManager.SingleTableEntityManger;
import HRComponents.DTOs.EntitysDTOs.UserDTO;


import java.util.concurrent.ConcurrentMap;
public interface UsersImplementations{
    void UpdateAll(ConcurrentMap <Integer,UserDTO> userDTO);
}

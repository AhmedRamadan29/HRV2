package HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceSingleEntity;
import HRComponents.DTOs.EntitysDTOs.UserDTO;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
public interface CRUDUsersServiceMethod  {
    List<UserDTO> getAll();
    List<UserDTO> create(List<UserDTO> tList);
    ConcurrentMap<Integer, UserDTO> UpdateUser(List<Integer> id,ConcurrentMap <Integer , UserDTO> userDTO);
}


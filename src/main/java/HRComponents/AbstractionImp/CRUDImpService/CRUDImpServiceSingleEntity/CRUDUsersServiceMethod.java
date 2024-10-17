package HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceSingleEntity;
import HRComponents.DTOs.EntitysDTOs.UserDTO;

import java.util.Hashtable;
import java.util.List;
public interface CRUDUsersServiceMethod  {
    List<UserDTO> getAll();
    List<UserDTO> create(List<UserDTO> tList);
    Hashtable<Integer, UserDTO> UpdateUser( List<Integer> id, Hashtable <Integer , UserDTO> userDTO);
}


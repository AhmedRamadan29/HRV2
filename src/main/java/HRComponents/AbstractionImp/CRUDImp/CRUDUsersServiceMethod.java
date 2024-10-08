package HRComponents.AbstractionImp.CRUDImp;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.DTOs.EntityDTOs.UserDTO;
import java.util.ArrayList;
import java.util.List;
public  interface    CRUDUsersServiceMethod  {
 default List<UserDTO> getAll() {return new ArrayList<>();}
 default List<UserDTO> create(List<UserDTO> tList) {return new ArrayList<>();}
 default List<UsersJoinSystemUsersDTO> getPrivate(String PrivateName) {
  return new ArrayList<>();
 }
 }


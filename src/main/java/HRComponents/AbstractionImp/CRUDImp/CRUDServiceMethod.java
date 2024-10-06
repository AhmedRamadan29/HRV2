package HRComponents.AbstractionImp.CRUDImp;
import HRComponents.DTOs.UserDTO;

import java.util.List;
public class CRUDServiceMethod {
@FunctionalInterface
public interface  GetAll<DTO>  { List<DTO> get();}

 @FunctionalInterface
 public interface Create<DTO>{
List<DTO> create(List< UserDTO> userDTO);

 }
}

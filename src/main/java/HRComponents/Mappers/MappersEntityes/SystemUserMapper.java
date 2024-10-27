package HRComponents.Mappers.MappersEntityes;
import HRComponents.DTOs.EntitysDTOs.SystemUserDTO;
import HRComponents.Entitys.SystemUser;
import org.springframework.stereotype.Component;
@Component
public class SystemUserMapper{
    public static SystemUserDTO systemUserToDTO(SystemUser systemUser){
        return SystemUserDTO.builder().id(systemUser.getId()).role(systemUser.getRole()).PrivilegeRole(systemUser.getPrivilegeRole()).build();
    }
    public static SystemUser systemUserToEntity(SystemUserDTO systemUserDTO){
        return SystemUser.builder().id(systemUserDTO.getId()).role(systemUserDTO.getRole()).PrivilegeRole(systemUserDTO.getPrivilegeRole()).build();
    }
}

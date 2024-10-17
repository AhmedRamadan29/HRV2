package HRComponents.Mappers.MappersEntityes;
import HRComponents.DTOs.EntitysDTOs.SystemUserDTO;
import HRComponents.Entitys.SystemUser;
import org.springframework.stereotype.Component;
@Component
public class SystemUserMapper {
    /**
     * Converts a SystemUser entity to a SystemUserDTO.
     *
     * @param systemUser the SystemUser entity to be converted
     * @return a SystemUserDTO containing the data from the SystemUser entity
     */
    public static SystemUserDTO systemUserToDTO(SystemUser systemUser) {
        return SystemUserDTO.builder().id(systemUser.getId()).role(systemUser.getRole()).PrivilegeRole(systemUser.getPrivilegeRole()).build();
    }
    /**
     * Converts a SystemUserDTO to a SystemUser entity.
     *
     * @param systemUserDTO the SystemUserDTO to be converted
     * @return a SystemUser entity containing the data from the SystemUserDTO
     */
    public static SystemUser systemUserToEntity(SystemUserDTO systemUserDTO) {
        return SystemUser.builder().id(systemUserDTO.getId()).role(systemUserDTO.getRole()).PrivilegeRole(systemUserDTO.getPrivilegeRole()).build();
    }
}

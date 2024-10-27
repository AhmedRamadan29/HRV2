package HRComponents.Mappers.MappersEntityes;
import HRComponents.DTOs.EntitysDTOs.EmployerDTO;
import HRComponents.Entitys.Employer;
import org.springframework.stereotype.Component;
@Component
public class EmployerMapper{
    public static EmployerDTO EmployerToDTO(Employer employer){
        return EmployerDTO.builder().id(employer.getId()).companyName(employer.getCompanyName()).phone(employer.getPhone()).webSites(employer.getWebSites()).build();
    }
    public static Employer EmployerToEntity(EmployerDTO employerDTO){
        return Employer.builder().id(employerDTO.getId()).companyName(employerDTO.getCompanyName()).webSites(employerDTO.getCompanyName()).phone(employerDTO.getPhone()).build();
    }
}

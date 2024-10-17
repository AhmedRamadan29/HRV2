package HRComponents.Mappers.MappersEntityes;
import HRComponents.DTOs.EntitysDTOs.EmployerDTO;
import HRComponents.Entitys.Employer;
import org.springframework.stereotype.Component;
@Component
public class EmployerMapper {
    /**
     * Converts an Employer entity to an EmployerDTO object.
     *
     * @param employer The Employer entity to be converted.
     * @return An EmployerDTO object containing the data from the Employer entity.
     *
     * <p>This function takes an Employer entity as input and creates a new EmployerDTO object.
     * The EmployerDTO object is then populated with the data from the Employer entity, specifically
     * the id, companyName, phone, and webSites fields. The function returns the constructed EmployerDTO object.
     *
     * <p>The EmployerDTO class is assumed to have a builder pattern for constructing instances,
     * with methods for setting each field (id, companyName, phone, webSites).
     */
    public static EmployerDTO EmployerToDTO(Employer employer) {
        return EmployerDTO.builder().id(employer.getId()).companyName(employer.getCompanyName()).phone(employer.getPhone()).webSites(employer.getWebSites()).build();
    }
    /**
     * Converts an EmployerDTO object to an Employer entity.
     *
     * @param employerDTO The EmployerDTO object to be converted.
     * @return An Employer entity containing the data from the EmployerDTO object.
     *
     * <p>This function takes an EmployerDTO object as input and creates a new Employer entity.
     * The Employer entity is then populated with the data from the EmployerDTO object, specifically
     * the id, companyName, phone, and webSites fields. The function returns the constructed Employer entity.
     *
     * <p>The Employer class is assumed to have a builder pattern for constructing instances,
     * with methods for setting each field (id, companyName, phone, webSites).
     *
     * <p>Note: The webSites field in the Employer entity is set to the same value as the companyName field
     * in the EmployerDTO object. If this is not the desired behavior, the webSites field should be updated
     * accordingly in the Employer entity.
     */
    public static Employer EmployerToEntity(EmployerDTO employerDTO) {
        return Employer.builder().id(employerDTO.getId()).companyName(employerDTO.getCompanyName()).webSites(employerDTO.getCompanyName()).phone(employerDTO.getPhone()).build();
    }
}

package HRComponents.Mappers.ReportsMappers;
import HRComponents.DTOs.CoustomJoinTablesDTOs.ReportGetAllInfoUserDTO;
import org.springframework.stereotype.Component;

@Component
public class ReportGetAllInfoMapper {

    /**
     * Converts a custom join table DTO to a ReportGetAllInfoUserDTO.
     *
     * @param reportGetAllInfoUserDTO The custom join table DTO to be converted.
     * @return The converted ReportGetAllInfoUserDTO.
     * <p>
     * Note: This method currently simply returns the input DTO as there is no actual mapping logic.
     * In a real-world scenario, this method would contain the necessary logic to convert the custom join table DTO
     * into the ReportGetAllInfoUserDTO.
     */
    public static ReportGetAllInfoUserDTO convertToDTO(ReportGetAllInfoUserDTO reportGetAllInfoUserDTO) {
        return reportGetAllInfoUserDTO;
    }
}


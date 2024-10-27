package HRComponents.Mappers.ReportsMappers;
import HRComponents.DTOs.CoustomJoinTablesDTOs.ReportGetAllInfoUserDTO;
import org.springframework.stereotype.Component;
@Component
public class ReportGetAllInfoMapper{
    public static ReportGetAllInfoUserDTO convertToDTO(Object[] tuple){
        return ReportGetAllInfoUserDTO.builder().firstName((String)tuple[0]).lastName((String)tuple[1]).birthDate((int)tuple[2]).position((String)tuple[3]).githubAccount((String)tuple[4]).linkedinAccount((String)tuple[5]).email((String)tuple[6]).status((boolean)tuple[7]).createdDate((String)tuple[8]).company((String)tuple[9]).website((String)tuple[10]).phoneNumber((String)tuple[11]).build();
    }
}

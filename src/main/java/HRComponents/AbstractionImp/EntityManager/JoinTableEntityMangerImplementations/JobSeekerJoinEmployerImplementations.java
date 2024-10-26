package HRComponents.AbstractionImp.EntityManager.JoinTableEntityMangerImplementations;
import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;

import java.util.List;
public interface JobSeekerJoinEmployerImplementations{
    List<JobSeekerJoinEmployerDTO> getAll();
    List<JobSeekerJoinEmployerDTO> getbyJob (String position);
}



package HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys;


import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;

import java.util.concurrent.CopyOnWriteArrayList;
public interface JobSeekerJoinEmployerServiceMethod {
    CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> getAll();
}

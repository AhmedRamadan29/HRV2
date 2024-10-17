package HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys;
import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;
import HRComponents.Exceptions.PublicLocalException;

import java.util.concurrent.CopyOnWriteArrayList;
public interface JobSeekerJoinEmployerServiceMethod{
    CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> getAll() throws PublicLocalException, InterruptedException;
}

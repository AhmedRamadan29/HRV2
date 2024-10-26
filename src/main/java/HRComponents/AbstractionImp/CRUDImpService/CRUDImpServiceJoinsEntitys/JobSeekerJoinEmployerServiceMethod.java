package HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys;
import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;
import HRComponents.Exceptions.PublicLocalException;

import java.util.List;
import java.util.concurrent.ExecutionException;
public interface JobSeekerJoinEmployerServiceMethod{
    List<JobSeekerJoinEmployerDTO> getAll() throws InterruptedException, PublicLocalException, ExecutionException;
List <JobSeekerJoinEmployerDTO> getByJob(String job) throws PublicLocalException;

}

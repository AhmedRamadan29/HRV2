package HRComponents.Services;
import HRComponents.AbstractionImp.CRUDImpService.JobSeekerJoinEmployerServiceMethod;
import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;
import HRComponents.Repostorys.EmployerDaoRepository;
import HRComponents.Repostorys.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobSeekerJoinEmployerService implements JobSeekerJoinEmployerServiceMethod {
    private final JobSeekerRepository jobSeekerRepository;
    private final EmployerDaoRepository employerDaoRepository;
    @Autowired
    public JobSeekerJoinEmployerService(JobSeekerRepository jobSeekerRepository, EmployerDaoRepository employerDaoRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
        this.employerDaoRepository = employerDaoRepository;
    }
    @Override
    public List<JobSeekerJoinEmployerDTO> GetAll() {
        return null;
    }
}

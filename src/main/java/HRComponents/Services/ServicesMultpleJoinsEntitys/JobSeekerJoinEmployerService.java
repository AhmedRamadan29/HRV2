package HRComponents.Services.ServicesMultpleJoinsEntitys;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.JobSeekerJoinEmployerServiceMethod;
import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;
import HRComponents.Exceptions.PublicLocalException;
import HRComponents.GlobalUseClass.RunnableThreadsGlobal.ExecutorServiceGlobal;
import HRComponents.Mappers.JoinImplelementathionsMappers.JobSeekerJoinEmployerMapper;
import HRComponents.Repostorys.EmployerDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
@Service
public class JobSeekerJoinEmployerService implements JobSeekerJoinEmployerServiceMethod{
    protected final EmployerDaoRepository employerDaoRepository;
    protected ExecutorServiceGlobal executorService;
    private ExecutorService executorServicewoman;
    private CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> jobSeekerJoinEmployerDTOS;
    @Autowired
    public JobSeekerJoinEmployerService(EmployerDaoRepository employerDaoRepository,ExecutorServiceGlobal executorService){this.executorService=executorService;this.employerDaoRepository=employerDaoRepository;}
    @Override
    public CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> getAll() throws PublicLocalException {
        this.executorService = new ExecutorServiceGlobal(3);
        try {

            executorService.executeTask(this::run);
        } catch (Exception e) {
            throw new PublicLocalException("Error executing task", e.toString());
        }
        return jobSeekerJoinEmployerDTOS;
    }


    private void run() {

        jobSeekerJoinEmployerDTOS = employerDaoRepository.getAll()
                .stream()
                .map(JobSeekerJoinEmployerMapper::JobSeekerJoinEmployerToDTO)
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }
}
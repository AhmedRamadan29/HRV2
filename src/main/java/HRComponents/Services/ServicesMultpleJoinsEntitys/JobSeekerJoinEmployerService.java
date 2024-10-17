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
import java.util.stream.Collectors;
@Service
public class JobSeekerJoinEmployerService implements JobSeekerJoinEmployerServiceMethod{
   protected final EmployerDaoRepository employerDaoRepository;
    protected final ExecutorServiceGlobal executorService;
    private CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> jobSeekerJoinEmployerDTOS;
    @Autowired
    public JobSeekerJoinEmployerService(EmployerDaoRepository employerDaoRepository,ExecutorServiceGlobal executorService){this.executorService=executorService;this.employerDaoRepository=employerDaoRepository;}

    @Override
    public CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> getAll() throws PublicLocalException, InterruptedException{
        executorService.createThreads(1);
        executorService.ReentrantLock().lock();
        try{
            executorService.executeTask(()->jobSeekerJoinEmployerDTOS=employerDaoRepository.getAll().parallelStream().map(JobSeekerJoinEmployerMapper::JobSeekerJoinEmployerToDTO).collect(Collectors.toCollection(CopyOnWriteArrayList::new)));
        }finally{
            executorService.ReentrantLock().unlock();
        }
        executorService.shutdownThread();
        return jobSeekerJoinEmployerDTOS;
    }
}

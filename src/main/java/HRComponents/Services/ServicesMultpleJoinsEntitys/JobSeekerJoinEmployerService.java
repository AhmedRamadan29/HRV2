package HRComponents.Services.ServicesMultpleJoinsEntitys;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.JobSeekerJoinEmployerServiceMethod;
import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;
import HRComponents.Exceptions.PublicLocalException;
import HRComponents.GlobalProjectPattern.RunnableThreadsGlobal.ExecutorServiceGlobal;
import HRComponents.Mappers.JoinImplelementathionsMappers.JobSeekerJoinEmployerMapper;
import HRComponents.Repostorys.EmployerDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.vavr.control.Try;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
@Service
public class JobSeekerJoinEmployerService implements JobSeekerJoinEmployerServiceMethod{
    protected final EmployerDaoRepository employerDaoRepository;
    protected ExecutorServiceGlobal executorService;
    @Autowired
    public JobSeekerJoinEmployerService(EmployerDaoRepository employerDaoRepository,ExecutorServiceGlobal executorService){this.executorService=executorService; this.employerDaoRepository=employerDaoRepository;}
    /**
     This private helper method fetches data from the employerDaoRepository,
     maps it to a list of JobSeekerJoinEmployerDTO objects,
     and stores it in a CopyOnWriteArrayList.
     It is called within the getAll()
     method
     to populate the jobSeekerJoinEmployerDTOS list.
     */
    private CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> RunGetAll(){
        return employerDaoRepository.getAll().stream().map(JobSeekerJoinEmployerMapper::JobSeekerJoinEmployerToDTO).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }
    /// This method retrieves all job seekers and their corresponding employer information.
    /// It uses an ExecutorService
    /// to run a task
    /// that fetches the data from the employerDaoRepository,
    /// maps it to a list of JobSeekerJoinEmployerDTO objects,
    /// and stores it in a CopyOnWriteArrayList.
    /// @return A CopyOnWriteArrayList of JobSeekerJoinEmployerDTO objects
    /// representing all job seekers
    /// and their employer information.
    /// @exception PublicLocalException If an error occurs
    /// while fetching the job seekers.
    @Override
    public CopyOnWriteArrayList<JobSeekerJoinEmployerDTO> getAll() throws PublicLocalException{
        this.executorService=new ExecutorServiceGlobal(3);
        executorService.executeTask(this::RunGetAll);
        return Try.of(this::RunGetAll).getOrElseThrow(throwable->new PublicLocalException("Error fetching job seekers",throwable.getMessage()));
    }
    /**
     This method retrieves a list of job seekers based on a specific job title.
     It uses the employerDaoRepository
     to fetch the relevant data
     and then maps it to a list of JobSeekerJoinEmployerDTO objects.
     @param job The job title
     for which to retrieve job seekers.
     @return A list of JobSeekerJoinEmployerDTO objects
     representing the job seekers with the specified job title.
     @exception PublicLocalException If an error occurs
     while fetching the job seekers.
     */
    @Override
    public List<JobSeekerJoinEmployerDTO> getByJob(String job) throws PublicLocalException{
        return Try.of(()->employerDaoRepository.getbyJob(job).stream().map(JobSeekerJoinEmployerMapper::JobSeekerJoinEmployerToDTO).distinct().toList()).getOrElseThrow(throwable->new PublicLocalException("Error while fetching job seekers",throwable.getMessage()));
    }
}
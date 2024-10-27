package HRComponents.Controllers;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.JobSeekerJoinEmployerServiceMethod;
import HRComponents.Exceptions.PublicLocalException;
import HRComponents.GlobalProjectPattern.CustomizedImplementationControllers.PaginationImplement;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutionException;
@RestController
@RequestMapping("/api/JobSeeker")
@CrossOrigin(origins="*")
public class JobSeekerController{
    private JobSeekerJoinEmployerServiceMethod jobSeekerJoinEmployerServiceMethod;
    private final PaginationImplement paginationImplement;
    @Autowired
    public JobSeekerController(JobSeekerJoinEmployerServiceMethod jobSeekerJoinEmployerServiceMethod,PaginationImplement paginationImplement){this.jobSeekerJoinEmployerServiceMethod=jobSeekerJoinEmployerServiceMethod; this.paginationImplement=paginationImplement;}
    /**
     This function retrieves all job seekers and their corresponding employers.
     It uses pagination to limit the number of results returned per request.
     @param page The page number to retrieve. Default value is 0.
     @param pageSize The number of results per page. Default value is 1.
     @return A ResponseEntity containing the paginated list of job seekers and employers.
     The HTTP status code is set to FOUND (200).
     @exception ExecutionException If an error occurs during the execution of the asynchronous task.
     @exception InterruptedException If the current thread is interrupted while waiting for the task to complete.
     @exception PublicLocalException If a custom exception is thrown during the operation.
     */
    @GetMapping("/getAllJobSeekerAndEmployer")
    public ResponseEntity<?> getAllJobSeekerAndEmployer(@RequestParam(defaultValue="0") long page,@RequestParam(defaultValue="1") long pageSize) throws ExecutionException, InterruptedException, PublicLocalException{return new ResponseEntity<>(this.paginationImplement.createPagination(this.jobSeekerJoinEmployerServiceMethod.getAll(),page,pageSize),HttpStatus.OK);}
    /**
     This function retrieves job seekers and their corresponding employers based on a specific job title.
     It uses pagination to limit the number of results returned per request.
     @param job The job title to filter job seekers by.
     @param page The page number to retrieve. Default value is 0.
     @param pageSize The number of results per page. Default value is 30.
     @return A ResponseEntity containing the paginated list of job seekers and employers who match the specified job title.
     The HTTP status code is set to OK (200) if the job title is not null, otherwise it is set to BAD_REQUEST (400).
     @exception PublicLocalException If a custom exception is thrown during the operation.
     */
    @GetMapping("/getAll/By/{job}")
    public ResponseEntity<?> GetbyJob(
     @PathVariable String job,@RequestParam(defaultValue="0") long page,@RequestParam(defaultValue="30") long pageSize) throws PublicLocalException
    {
        return Try.of(()->{
            if(job!=null){
                return new ResponseEntity<>(paginationImplement.createPagination(jobSeekerJoinEmployerServiceMethod.getByJob(job),page,pageSize),HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }).getOrElseThrow(TableRow->new PublicLocalException("Error GetbyJob "+TableRow.getClass(),TableRow.toString()));
    }
}


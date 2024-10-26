package HRComponents.Controllers;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.JobSeekerJoinEmployerServiceMethod;
import HRComponents.Exceptions.PublicLocalException;
import HRComponents.GlobalUseClass.CustomizedImplementationControllers.PaginationImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutionException;
@RestController
@RequestMapping("/api/JobSeeker")
@CrossOrigin(origins="*")
public class JobSeekerController{
    private JobSeekerJoinEmployerServiceMethod jobSeekerJoinEmployerServiceMethod;
    private  final PaginationImplement paginationImplement;
    @Autowired
    public JobSeekerController(JobSeekerJoinEmployerServiceMethod jobSeekerJoinEmployerServiceMethod ,
                               PaginationImplement paginationImplement){this.jobSeekerJoinEmployerServiceMethod=jobSeekerJoinEmployerServiceMethod;this.paginationImplement=paginationImplement;}
    
    
    /**
 * This function retrieves all job seekers and their corresponding employers.
 * It uses pagination to limit the number of results returned per request.
 *
 * @param page The page number to retrieve. Default value is 0.
 * @param pageSize The number of results per page. Default value is 1.
 * @return A ResponseEntity containing the paginated list of job seekers and employers.
 *         The HTTP status code is set to FOUND (200).
 * @throws ExecutionException If an error occurs during the execution of the asynchronous task.
 * @throws InterruptedException If the current thread is interrupted while waiting for the task to complete.
 * @throws PublicLocalException If a custom exception is thrown during the operation.
 */
@GetMapping("/getAllJobSeekerAndEmployer")
public ResponseEntity<?> getAllJobSeekerAndEmployer(@RequestParam(defaultValue="0") long page,
                                                   @RequestParam(defaultValue="1") long pageSize) throws ExecutionException, InterruptedException, PublicLocalException {
    return new ResponseEntity<>(this.paginationImplement.createPagination(this.jobSeekerJoinEmployerServiceMethod.getAll(), page, pageSize), HttpStatus.FOUND);
}





    }


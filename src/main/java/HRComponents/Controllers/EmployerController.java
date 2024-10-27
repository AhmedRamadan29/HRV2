package HRComponents.Controllers;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceSingleEntity.EmployerMethod;
import HRComponents.GlobalProjectPattern.CustomizedImplementationControllers.PaginationImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/API/Employees")
public class EmployerController{
    private final EmployerMethod employerMethod;
    private final PaginationImplement paginationImplement;
    @Autowired
    public EmployerController(EmployerMethod employerMethod,PaginationImplement paginationImplement){this.employerMethod=employerMethod; this.paginationImplement=paginationImplement;}
    /**
     Retrieves all Employers with pagination.
     @param page The page number to retrieve. Default value is 0.
     @param pageSize The number of Employers per page. Default value is 30.
     @return A ResponseEntity containing the paginated Employers and HTTP status OK.
     */
    @GetMapping("/All/Employees")
    public ResponseEntity<?> GetAllEmployees(@RequestParam(defaultValue="0") long page,@RequestParam(defaultValue="30") long pageSize){return new ResponseEntity<>(this.paginationImplement.createPagination(this.employerMethod.EmployerFindAll(),page,pageSize),HttpStatus.OK);}
}

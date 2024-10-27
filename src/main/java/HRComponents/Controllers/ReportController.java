package HRComponents.Controllers;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.ReportsServiceMethod;
import HRComponents.Exceptions.PublicLocalException;
import HRComponents.GlobalProjectPattern.CustomizedImplementationControllers.PaginationImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/Report")
@CrossOrigin("*")
public class ReportController{
    public final PaginationImplement paginationImplement;
    public final ReportsServiceMethod reportsServiceMethod;
    @Autowired
    public ReportController(PaginationImplement paginationImplement,ReportsServiceMethod reportsServiceMethod){
        this.paginationImplement=paginationImplement;
        this.reportsServiceMethod=reportsServiceMethod;
    }
    /**
     This function is responsible for retrieving a paginated report of all users based on their privilege.
     @param page The current page number for pagination. Default value is 0.
     @param pageSize The number of records per page for pagination. Default value is 1.
     @param Privilege The privilege of the users to be included in the report.
     @return A ResponseEntity containing the paginated report of users with the specified privilege.
     The HTTP status code is set to OK (200).
     @exception PublicLocalException If any error occurs during the retrieval or pagination process.
     */
    @GetMapping("/info/AllUsersReport/{Privilege}")
    public ResponseEntity<List> ShowAllUser(
     @RequestParam(defaultValue="0") long page,@RequestParam(defaultValue="10") long pageSize,@PathVariable String Privilege) throws PublicLocalException
    {
        return new ResponseEntity<>(paginationImplement.createPagination(reportsServiceMethod.findUsersReport(Privilege),page,pageSize),HttpStatus.OK);
    }
}


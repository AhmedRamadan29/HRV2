package HRComponents.Controllers;
import HRComponents.DTOs.EntityDTOs.UserDTO;
import HRComponents.FrontEndImplementation.PaginationImplement;
import HRComponents.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/API/users")
@CrossOrigin(origins = "*")
public class UserController {
    private UserService userService;
    private PaginationImplement paginationImplement = PaginationImplement.getInstance();
    @Autowired
    public UserController(UserService userService) {this.userService = userService;}
    /**
     * Retrieves a paginated list of users.
     *
     * @param page     The page number to retrieve (default is 0).
     * @param pageSize The number of users per page (default is 10).
     * @return A ResponseEntity containing a list of UserDTO objects for the specified page and page size.
     * If no users are found or the list is null, a ResponseEntity with a NOT_FOUND status is returned.
     */
    @GetMapping("/GetAllUsers")
    public ResponseEntity<?> getallUsers(@RequestParam(defaultValue = "0") long page, @RequestParam(defaultValue = "10") long pageSize) {
        return new ResponseEntity<>(this.paginationImplement.createPagination(this.userService.getAll(), page, pageSize), HttpStatus.FOUND);
    }
    /**
     * Adds a list of users to the system.
     *
     * @param users A list of UserDTO objects representing the users to be added.
     *              If the list is null or empty, a BAD_REQUEST response is returned.
     * @return A ResponseEntity containing the list of created UserDTO objects with a CREATED status.
     * If the input list is null or empty, a ResponseEntity with a BAD_REQUEST status is returned.
     */
    @PostMapping("/AddUsers")
    public ResponseEntity<List<UserDTO>> addUsers(@RequestBody List<UserDTO> users) {
        if (users == null || users.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(this.userService.create(users), HttpStatus.CREATED);
    }
    /**
 * Retrieves a paginated list of users based on their private name.
 *
 * @param PrivateName The private name of the users to retrieve.
 * @param page        The page number to retrieve (default is 0).
 * @param pageSize    The number of users per page (default is 2).
 * @return A ResponseEntity containing a list of UserDTO objects for the specified private name, page, and page size.
 * If no users are found or the list is null, a ResponseEntity with a NOT_FOUND status is returned.
 */
@GetMapping("/GetUsersByPrivate/{PrivateName}")
public ResponseEntity<?> GetInfoUsersByPrivate(@PathVariable String PrivateName, @RequestParam(defaultValue = "0") long page, @RequestParam(defaultValue = "2") long pageSize) {
    return new ResponseEntity<>(this.paginationImplement.createPagination(this.userService.getPrivate(PrivateName), page, pageSize), HttpStatus.FOUND);
}

    @GetMapping("/GetInfoUsersRroles/{role}")
    public ResponseEntity<?>  getUserIsActive (@PathVariable String role, @RequestParam(defaultValue="0") long page, @RequestParam(defaultValue = "2") long pageSize) {
        return  new ResponseEntity<>(this.paginationImplement. createPagination(this.userService.getUserIsActive(role), page, pageSize) , HttpStatus.FOUND);}

}

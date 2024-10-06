package HRComponents.Controllers;
import HRComponents.DTOs.UserDTO;
import HRComponents.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/API/users")
@CrossOrigin(origins = "*")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {this.userService = userService;}
    @GetMapping("/GetAllUsers")
    public ResponseEntity<?> getallUsers(@RequestParam(defaultValue ="0") int page , @RequestParam(defaultValue="10") int pageSize ) {
        List<UserDTO> users = userService.getAll.get();
       if (users == null || users.isEmpty() ){return new ResponseEntity<>("Users  Not found or  null ", HttpStatus.NOT_FOUND);}
       List<UserDTO> PageUsers =users.stream().skip((long) page * pageSize).limit(pageSize).collect(Collectors.toList());
        return new  ResponseEntity<>(PageUsers , HttpStatus.FOUND );}


    @PatchMapping("AddUsers")
    public  ResponseEntity <List<UserDTO>> addUsers(@RequestBody List<UserDTO> users){



return new  ResponseEntity<>(userService.create.create(users) ,HttpStatus.CREATED );
    }



}

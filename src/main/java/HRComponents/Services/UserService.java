package HRComponents.Services;
import HRComponents.AbstractionImp.CRUDImp.CRUDUsersServiceMethod;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.DTOs.EntityDTOs.UserDTO;
import HRComponents.Mapper.UserMapper;
import HRComponents.Repostorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements CRUDUsersServiceMethod {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * Retrieves all user records from the database.
     *
     * @return a list of UserDTO objects representing all users in the database.
     */
    @Override
    public List<UserDTO> getAll() {return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());}
    /**
     * Creates new user records in the database.
     *
     * @param users a list of UserDTO objects representing the users to be created.
     * @return a list of UserDTO objects representing the newly created users.
     */
    @Override
    @Transactional
    public List<UserDTO> create(List<UserDTO> users) {return userRepository.saveAll(users.stream().map(UserMapper::toEntity).collect(Collectors.toList())).stream().map(UserMapper::toDTO).collect(Collectors.toList());}
    @Override
    public List<UsersJoinSystemUsersDTO> getPrivate(String PrivateName) {
        return userRepository.findUsersWithRole(PrivateName);



    }



}

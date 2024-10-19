package HRComponents.Services.ServiceSingleEntitys;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceSingleEntity.CRUDUsersServiceMethod;
import HRComponents.DTOs.EntitysDTOs.UserDTO;
import HRComponents.Mappers.MappersEntityes.UserMapper;
import HRComponents.Repostorys.SystemUserRepository;
import HRComponents.Repostorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
@Service
public class UserService implements CRUDUsersServiceMethod {
    protected final UserRepository userRepository;
    protected final SystemUserRepository systemUserRepository;

    @Autowired
    public UserService(UserRepository userRepository, SystemUserRepository systemUserRepository) {
        this.userRepository = userRepository;
        this.systemUserRepository = systemUserRepository;
    }

    /**
     * Retrieves all users from the system.
     * This method fetches all user entities from the database, converts them to UserDTO objects,
     * and returns the result as a CopyOnWriteArrayList.
     * The method uses a parallel stream for potential performance improvements in a multithreaded environment.
     *
     * @return a CopyOnWriteArrayList of UserDTO objects representing all users in the system
     */
    @Override
    public CopyOnWriteArrayList<UserDTO> getAll() {
        return this.userRepository.findAll().parallelStream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    /**
     * Creates a list of users in the system.
     * This method receives a list of UserDTO objects, converts each DTO to its corresponding entity,
     * saves all the entities to the database using the userRepository, and then converts the saved entities
     * back to DTOs to return the list of newly created users.
     *
     * @param users a list of UserDTO objects representing the users to be created
     * @return a list of UserDTO objects representing the newly created users
     */
    @Override
    @Transactional
    public List<UserDTO> create(List<UserDTO> users) {
        return this.userRepository.saveAll(users.parallelStream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList()))
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Updates a set of users in the system based on their IDs and corresponding UserDTO objects.
     *
     * @param id a List of Integer representing the IDs of the users to be updated.
     * @param userDTO a Hashtable of Integer and UserDTO, where the key is the user's ID and the value is the corresponding UserDTO object.
     * @return a Hashtable of Integer and UserDTO representing the updated users.
     * @throws IllegalArgumentException if any of the IDs in the provided list do not correspond to any user in the system.
     * @throws NullPointerException if any of the UserDTO objects in the provided Hashtable are null.
     */
    @Transactional
    @Override
    public Hashtable<Integer, UserDTO> UpdateUser(List<Integer> id, Hashtable<Integer, UserDTO> userDTO) {
        id.forEach(ID -> {
            UserDTO user = userDTO.get(ID);
            if (user != null) {
                userRepository.UpdateAll(userDTO);
            }
        });
        return userDTO;
    }
}


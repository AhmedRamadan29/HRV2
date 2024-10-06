package HRComponents.Services;
import HRComponents.AbstractionImp.CRUDImp.CRUDServiceMethod;
import HRComponents.DTOs.UserDTO;
import HRComponents.Entitys.User;
import HRComponents.Mapper.UserMapper;
import HRComponents.Repostorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public CRUDServiceMethod.GetAll<UserDTO> getAll = () ->
            userRepository.findAll()
                    .stream()
                    .map(UserMapper::toDTO)
                    .collect(Collectors.toList());


    public CRUDServiceMethod.Create<UserDTO> create = (users) -> {
        List<User> userEntities = users.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
        return userRepository.saveAll(userEntities)
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    };

    @Transactional
    public List<UserDTO> saveUsers(List<UserDTO> users) {
        return create.create(users);
    }
}

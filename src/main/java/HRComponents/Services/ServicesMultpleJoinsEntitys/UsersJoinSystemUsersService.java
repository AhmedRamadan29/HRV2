package HRComponents.Services.ServicesMultpleJoinsEntitys;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.UsersJoinSystemUsersMethod;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.DTOs.EntitysDTOs.SystemUserDTO;
import HRComponents.DTOs.EntitysDTOs.UserDTO;
import HRComponents.Mappers.MappersEntityes.SystemUserMapper;
import HRComponents.Mappers.MappersEntityes.UserMapper;
import HRComponents.Repostorys.SystemUserRepository;
import HRComponents.Repostorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
@Service
public class UsersJoinSystemUsersService implements UsersJoinSystemUsersMethod{

    private final UserRepository userRepository;
    private final SystemUserRepository systemUserRepository;
    @Autowired
    public UsersJoinSystemUsersService(UserRepository userRepository,SystemUserRepository systemUserRepository){
        this.userRepository=userRepository;
        this.systemUserRepository=systemUserRepository;
    }
    /**
     * Retrieves a list of users joined with system users based on a specified private name.
     *
     * @param PrivateName the private name used to filter users.
     * @return a List of UsersJoinSystemUsersDTO objects, representing the joined data of users with the specified private name.
     */
    @Override
    public List<UsersJoinSystemUsersDTO> getPrivate(String PrivateName) {
        return this.userRepository.findUsersWithRole(PrivateName);
    }
    /**
     * Retrieves a list of active users joined with system users based on a specified role.
     *
     * @param role the role to filter system users by.
     * @return a CopyOnWriteArrayList of UsersJoinSystemUsersDTO objects, representing the joined data of active users and system users with the specified role.
     */
    @Override
    public CopyOnWriteArrayList<UsersJoinSystemUsersDTO> getUserIsActive(String role) {
        CopyOnWriteArrayList<UserDTO> users = this.userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        CopyOnWriteArrayList<SystemUserDTO> Systemusers = this.systemUserRepository.findAll().stream().map(SystemUserMapper::systemUserToDTO).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        return users.stream().flatMap(Users->Systemusers.stream().filter(System->System.getRole().equals(role)).map(B->UsersJoinSystemUsersDTO.builder().email(Users.getEmail()).isActivated(Users.isActivated()).createdDate(Users.getCreatedDate()).status(Users.isStatus()).role(B.getRole()).build())).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }
}

package HRComponents.Repostorys;
import HRComponents.AbstractionImp.EntityManager.JoinTableEntityMangerImplementations.UsersJoinSystemUsersImplementations;
import HRComponents.AbstractionImp.EntityManager.SingleTableEntityManger.UsersImplementations;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.DTOs.EntitysDTOs.UserDTO;
import HRComponents.Entitys.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer>, UsersJoinSystemUsersImplementations  , UsersImplementations{
    @Query("SELECT new HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO" + "(A.email, A.createdDate, A.password, A.isActivated, A.status, B.role) " + "FROM Users A JOIN A.SystemUser B WHERE B.role = :roleName")
    @Override
    List<UsersJoinSystemUsersDTO> findUsersWithRole(@Param("roleName") String roleName);
    @Modifying
    @Transactional
    @Query(value = "UPDATE  UserDTO SET isActivated = :#{#userDTO.isActivated}, status = :#{#userDTO.status}, email = :#{#userDTO.email}, password = :#{#userDTO.password} WHERE id = :#{#userDTO.id}", nativeQuery = true)
    @Override
    void UpdateAll(@Param("userDTO") Hashtable<Integer, UserDTO> userDTO);
}


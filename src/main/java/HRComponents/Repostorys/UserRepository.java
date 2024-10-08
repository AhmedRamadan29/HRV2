package HRComponents.Repostorys;
import HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO;
import HRComponents.EntityManager.UsersCustomImplementations;
import HRComponents.Entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>, UsersCustomImplementations {
    @Query("SELECT new HRComponents.DTOs.CoustomJoinTablesDTOs.UsersJoinSystemUsersDTO" + "(A.email, A.createdDate, A.password, A.isActivated, A.status, B.role) " + "FROM Users A JOIN A.SystemUser B WHERE B.role = :roleName")
    @Override
    List<UsersJoinSystemUsersDTO> findUsersWithRole(@Param("roleName") String roleName);


}


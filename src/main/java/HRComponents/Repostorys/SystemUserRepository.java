package HRComponents.Repostorys;
import HRComponents.Entitys.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {

}

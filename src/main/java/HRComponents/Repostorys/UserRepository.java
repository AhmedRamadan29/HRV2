package HRComponents.Repostorys;
import HRComponents.Entitys.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


}


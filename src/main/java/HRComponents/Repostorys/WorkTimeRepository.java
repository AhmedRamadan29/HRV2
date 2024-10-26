package HRComponents.Repostorys;
import HRComponents.Entitys.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Integer> {

}

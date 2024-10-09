package HRComponents.Repostorys;
import HRComponents.Entitys.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlace, Integer> {
    WorkPlace getById(int id);
}

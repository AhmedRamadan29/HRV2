package HRComponents.Repostorys;
import HRComponents.Entitys.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CityDaoRepository extends JpaRepository<City, Integer> {
    City getCityById(int id);
}

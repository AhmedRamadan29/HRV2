package HRComponents.Repostorys;
import HRComponents.Entitys.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
}

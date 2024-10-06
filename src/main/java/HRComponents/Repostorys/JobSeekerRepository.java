package HRComponents.Repostorys;

import HRComponents.Entitys.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Integer> {

    List<JobSeeker> findByNationalityId(long nationalityId);

    JobSeeker findById(int id);

    @Query("from JobSeeker j inner join j.workExperiences w order by w.startingDate desc ")
    List<JobSeeker> findByOrderByWorkExperiences_StartingDateDesc();
}

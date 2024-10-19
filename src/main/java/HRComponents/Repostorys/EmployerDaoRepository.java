package HRComponents.Repostorys;
import HRComponents.AbstractionImp.EntityManager.JoinTableEntityMangerImplementations.JobSeekerJoinEmployerImplementations;
import HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO;
import HRComponents.Entitys.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerDaoRepository extends JpaRepository<Employer,Integer>, JobSeekerJoinEmployerImplementations{
    @Query("select new  HRComponents.DTOs.CoustomJoinTablesDTOs.JobSeekerJoinEmployerDTO (A.firstName , A.lastName , A.birthDate , A.nationalityId , A.githubAccount , A.info , A.linkedInAccount ,B.companyName , B.phone , B.webSites  )from JobSeeker A JOIN A.employer  B ")
    @Override
    List<JobSeekerJoinEmployerDTO> getAll();
}





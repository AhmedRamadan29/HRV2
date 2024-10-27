package HRComponents.Repostorys;
import HRComponents.AbstractionImp.EntityManager.JoinTableEntityMangerImplementations.ReportsImplementations;
import HRComponents.DTOs.CoustomJoinTablesDTOs.ReportGetAllInfoUserDTO;
import HRComponents.Entitys.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Integer>, ReportsImplementations{
    @Query(value="SELECT DISTINCT "+"A.firstname AS firstName, "+"A.lastname AS lastName, "+"A.birthdate AS birthDate, "+"YEAR(CURDATE()) - YEAR(A.birthdate) AS age, "+"A.nationalityid AS nationalityId, "+"A.info_about_job_seeker AS position, "+"A.github_account AS githubAccount, "+"A.linkedin_account AS linkedinAccount, "+"B.email AS email, "+"B.status AS status, "+"DATE_FORMAT(B.createddate, '%d/%m/%Y') AS createdDate, "+"C.companyname AS company, "+"C.website AS website, "+"C.phoneNumber AS phoneNumber "+"FROM job_seekers A "+"RIGHT JOIN users B ON B.Privilege_id = A.job_position_id "+"JOIN employers C ON A.job_position_id = C.userid "+"JOIN system_users E ON A.job_position_id = E.Privilege_Role_id "+"WHERE A.job_position_id IN (SELECT E.Privilege_Role_id FROM system_users E WHERE E.role = :PrivilegeName) "+"ORDER BY A.firstname, A.lastname, position, age, status DESC, company, A.birthdate", nativeQuery=true)
    @Override
    List<ReportGetAllInfoUserDTO> reportGetAllInfoUsers(@Param("PrivilegeName") String Privilege);
}

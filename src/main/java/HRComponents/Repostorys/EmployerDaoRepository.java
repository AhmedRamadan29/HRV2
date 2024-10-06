package HRComponents.Repostorys;


import HRComponents.Entitys.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployerDaoRepository extends JpaRepository<Employer,Integer> {

    Employer getEmployerById(int id);

}

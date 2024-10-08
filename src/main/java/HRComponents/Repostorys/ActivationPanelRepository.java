package HRComponents.Repostorys;
import HRComponents.Entitys.ActivationPanelForSystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationPanelRepository extends JpaRepository<ActivationPanelForSystemUser,Integer> {

    ActivationPanelForSystemUser getActivationPanelForSystemUserByJobId_Id(int id);
}

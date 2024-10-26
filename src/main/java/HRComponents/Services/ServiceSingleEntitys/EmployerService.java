package HRComponents.Services.ServiceSingleEntitys;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceSingleEntity.EmployerMethod;
import HRComponents.DTOs.EntitysDTOs.EmployerDTO;
import HRComponents.Mappers.MappersEntityes.EmployerMapper;
import HRComponents.Repostorys.EmployerDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
@Service
public class EmployerService implements EmployerMethod{
    protected EmployerDaoRepository employerDaoRepository;
    @Autowired
    private EmployerService(EmployerDaoRepository employerDaoRepository){this.employerDaoRepository=employerDaoRepository;}
    /**
     This method retrieves all Employer entities from the database and maps them to their corresponding DTOs.
     @return A CopyOnWriteArrayList of EmployerDTO objects, representing the Employer entities from the database.
     */
    @Override
    public CopyOnWriteArrayList<EmployerDTO> EmployerFindAll(){
        return employerDaoRepository.findAll().parallelStream().map(EmployerMapper::EmployerToDTO).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }
}

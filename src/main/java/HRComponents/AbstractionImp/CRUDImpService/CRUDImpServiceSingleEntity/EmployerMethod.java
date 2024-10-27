package HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceSingleEntity;
import HRComponents.DTOs.EntitysDTOs.EmployerDTO;

import java.util.concurrent.CopyOnWriteArrayList;
public interface EmployerMethod{
    CopyOnWriteArrayList<EmployerDTO> EmployerFindAll();
}

package HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys;
import HRComponents.DTOs.CoustomJoinTablesDTOs.ReportGetAllInfoUserDTO;
import HRComponents.Exceptions.PublicLocalException;

import java.util.concurrent.CopyOnWriteArrayList;
public interface ReportsServiceMethod{
    CopyOnWriteArrayList<ReportGetAllInfoUserDTO> findUsersReport(String Privilege) throws PublicLocalException;
}

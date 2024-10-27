package HRComponents.Services.Reports;
import HRComponents.AbstractionImp.CRUDImpService.CRUDImpServiceJoinsEntitys.ReportsServiceMethod;
import HRComponents.DTOs.CoustomJoinTablesDTOs.ReportGetAllInfoUserDTO;
import HRComponents.Exceptions.PublicLocalException;
import HRComponents.GlobalProjectPattern.RunnableThreadsGlobal.ForkBoolTreed;
import HRComponents.Mappers.ReportsMappers.ReportGetAllInfoMapper;
import HRComponents.Repostorys.JobSeekerRepository;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
@Service
public class ReportsUsersInfoService implements ReportsServiceMethod{
    private final JobSeekerRepository jobSeekerRepository;
    public final ForkBoolTreed forkBoolTreed;
    @Autowired
    public ReportsUsersInfoService(JobSeekerRepository jobSeekerRepository,ForkBoolTreed forkBoolTreed){this.jobSeekerRepository=jobSeekerRepository;this.forkBoolTreed=forkBoolTreed;}
    /**
     This method retrieves a list of job seekers with their detailed information based on a given privilege.
     It uses a parallel stream to improve performance and a custom fork-join pool to handle concurrent execution.
     @param Privilege The privilege to filter job seekers by.
     @return A list of {@link ReportGetAllInfoUserDTO} objects representing the job seekers with their detailed information.
     @exception PublicLocalException If an error occurs while fetching job seekers.
     */
    @Override
    public CopyOnWriteArrayList<ReportGetAllInfoUserDTO> findUsersReport(String Privilege) throws PublicLocalException{
        return Try.of(()->forkBoolTreed.CreateFork(2).submit(()->jobSeekerRepository.reportInfoUsers(Privilege).parallelStream().map(ReportGetAllInfoMapper::convertToDTO)
         .collect(Collectors.toCollection(CopyOnWriteArrayList::new))).join()).getOrElseThrow(ReaderEX->new PublicLocalException("Error while fetching ReportGetAllInfoUserDTO",ReaderEX.getMessage()));
    }
}

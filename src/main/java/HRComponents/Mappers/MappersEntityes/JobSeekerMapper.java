package HRComponents.Mappers.MappersEntityes;
import HRComponents.DTOs.EntitysDTOs.JobSeekerDTO;
import HRComponents.Entitys.JobSeeker;
import org.springframework.stereotype.Component;
@Component
public class JobSeekerMapper{
    public static JobSeekerDTO jobSeekerToDTO(JobSeeker jobSeeker){
        return JobSeekerDTO.builder().id(jobSeeker.getId()).info(jobSeeker.getInfo()).birthDate(jobSeeker.getBirthDate()).firstName(jobSeeker.getFirstName()).lastName(jobSeeker.getLastName()).githubAccount(jobSeeker.getGithubAccount()).linkedInAccount(jobSeeker.getLinkedInAccount()).nationalityId(jobSeeker.getNationalityId()).build();
    }
    public static JobSeeker JobSeekerToEntity(JobSeekerDTO jobSeekerDTO){
        return JobSeeker.builder().id(jobSeekerDTO.getId()).birthDate(jobSeekerDTO.getBirthDate()).firstName(jobSeekerDTO.getFirstName()).githubAccount(jobSeekerDTO.getGithubAccount()).linkedInAccount(jobSeekerDTO.getLinkedInAccount()).lastName(jobSeekerDTO.getLastName()).info(jobSeekerDTO.getInfo()).nationalityId(jobSeekerDTO.getNationalityId()).build();
    }
}

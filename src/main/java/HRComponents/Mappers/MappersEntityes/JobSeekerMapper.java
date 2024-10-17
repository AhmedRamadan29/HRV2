package HRComponents.Mappers.MappersEntityes;
import HRComponents.DTOs.EntitysDTOs.JobSeekerDTO;
import HRComponents.Entitys.JobSeeker;
import org.springframework.stereotype.Component;
@Component
public class JobSeekerMapper {
    /**
     * Converts a {@link HRComponents.Entitys.JobSeeker} object to a {@link HRComponents.DTOs.EntitysDTOs.JobSeekerDTO}.
     *
     * @param jobSeeker The {@link HRComponents.Entitys.JobSeeker} object to be converted.
     * @return A {@link HRComponents.DTOs.EntitysDTOs.JobSeekerDTO} object representing the same data as the input {@link HRComponents.Entitys.JobSeeker}.
     */
    public static JobSeekerDTO jobSeekerToDTO(JobSeeker jobSeeker) {
        return JobSeekerDTO.builder().id(jobSeeker.getId()).info(jobSeeker.getInfo()).birthDate(jobSeeker.getBirthDate()).firstName(jobSeeker.getFirstName()).lastName(jobSeeker.getLastName()).githubAccount(jobSeeker.getGithubAccount()).linkedInAccount(jobSeeker.getLinkedInAccount()).nationalityId(jobSeeker.getNationalityId()).build();
    }
    /**
     * Converts a {@link HRComponents.DTOs.EntitysDTOs.JobSeekerDTO} object to a {@link HRComponents.Entitys.JobSeeker}.
     *
     * @param jobSeekerDTO The {@link HRComponents.DTOs.EntitysDTOs.JobSeekerDTO} object to be converted.
     * @return A {@link HRComponents.Entitys.JobSeeker} object representing the same data as the input {@link HRComponents.DTOs.EntitysDTOs.JobSeekerDTO}.
     */
    public static JobSeeker JobSeekerToEntity(JobSeekerDTO jobSeekerDTO) {
        return JobSeeker.builder().id(jobSeekerDTO.getId()).birthDate(jobSeekerDTO.getBirthDate()).firstName(jobSeekerDTO.getFirstName()).githubAccount(jobSeekerDTO.getGithubAccount()).linkedInAccount(jobSeekerDTO.getLinkedInAccount()).lastName(jobSeekerDTO.getLastName()).info(jobSeekerDTO.getInfo()).nationalityId(jobSeekerDTO.getNationalityId()).build();
    }
}

package HRComponents.Entitys;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Table(name="images")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Image{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id") private int id;
    @ManyToOne() @JoinColumn(name="job_seeker_id", referencedColumnName="id") @JsonIgnore private JobSeeker jobSeeker;
    @Column(name="image_title") private String imageTitle;
    @Column(name="image") private String imagePath;
}

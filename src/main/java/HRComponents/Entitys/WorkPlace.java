package HRComponents.Entitys;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workPlace")
public class WorkPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "work_place_name")
    private String workPlaceName;
    @JsonIgnore
    @OneToMany(mappedBy = "workPlace")
    private List<Job> jobs;
}

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
@Table(name = "work_time")
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "work_time_name")
    private String workTimeName;
    @JsonIgnore
    @OneToMany(mappedBy = "workTime")
    private List<Job> jobs;
}

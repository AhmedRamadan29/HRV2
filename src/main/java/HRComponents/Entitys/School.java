package HRComponents.Entitys;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","attendedSchools","departments"})
public class School{
    @Id @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
    @OneToMany(fetch=FetchType.LAZY, targetEntity=Department.class, cascade=CascadeType.ALL) @JoinColumn(name="id") @JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) private List<Department> departments;
    @JsonIgnore @OneToMany(mappedBy="school") private List<AttendedSchool> attendedSchools;
    @Column(name="school_name") private String schoolName;
}

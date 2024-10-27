package HRComponents.Entitys;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="language_levels")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","knownLanguages"})
public class LanguageLevel{
    @Id @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
    @Column(name="level_description") private String levelDescription;
    @OneToMany(mappedBy="languageLevel") private List<KnownLanguage> knownLanguages;
}

package mohamedDev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Name {
    @Id
    private Integer id;
    private String  firstname	;
    private String  lastname	;
}

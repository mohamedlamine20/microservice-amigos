package mohamedDev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rating {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    private Double rate;
    private Integer count;
}

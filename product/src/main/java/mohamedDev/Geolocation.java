package mohamedDev;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
 @AllArgsConstructor
@NoArgsConstructor
@Data
public class Geolocation {

    @Id
    private Integer id;

    private String  lat	;

    @JsonProperty("long")
    private String longe	;
}

package mohamedDev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}

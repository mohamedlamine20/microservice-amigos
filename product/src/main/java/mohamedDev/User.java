package mohamedDev;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @JsonIgnore
    @Id
    private Integer id;

    @JsonProperty("email")
   private String   email;
    @JsonProperty("username")
   private String  username	;
    @JsonProperty("password")
   private String password	;

   @OneToOne
   private Name  name ;
    @JsonProperty("phone")
   private String  phone;
   @OneToOne
   private Address address;

}

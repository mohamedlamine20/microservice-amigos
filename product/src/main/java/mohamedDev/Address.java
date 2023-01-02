package mohamedDev;


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
public class Address {
    @Id
    private Integer id;
  private String city;
  private String street;
  private Integer number;

  private String zipcode;

  @OneToOne
  private Geolocation geolocation;



}

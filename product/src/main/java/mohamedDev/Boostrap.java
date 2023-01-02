package mohamedDev;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Boostrap implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private final ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<Object[]> forEntity = restTemplate.getForEntity("https://fakestoreapi.com/products", Object[].class);

        Object[] objects = forEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Product> products = Arrays.stream(objects).map(object -> mapper.convertValue(object, Product.class)).collect(Collectors.toList());
        System.out.println(products.size());
        products.forEach(System.out::println);
        ResponseEntity<Object[]> forEntity1 = restTemplate.getForEntity("https://fakestoreapi.com/users", Object[].class);
        List<User> users = Arrays.stream(forEntity1.getBody()).map(object -> mapper.convertValue(object, User.class)).collect(Collectors.toList());
        System.out.println(users.size());
        System.out.println(users.get(1));



    }
}

package mohamedDev;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    private String message;
    private Date createdAt;
    private String messageId;

}

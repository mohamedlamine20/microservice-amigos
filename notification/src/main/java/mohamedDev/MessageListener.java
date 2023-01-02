package mohamedDev;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = "message")
    public void listener(Message message){
        System.out.println(message);
    }
}

package gov.Gferias.features.usersSumary;

import gov.Gferias.domain.usersSumary.model.UsersSumary;
import gov.Gferias.domain.usersSumary.repository.UsersSumaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersSumaryConsumer {

    private final UsersSumaryRepository usersSumaryRepository;

    @RabbitListener(queues = "user.created.queue")
    public void consume(UserCreatedEvent event){

        if (usersSumaryRepository.existsById(event.getId())) {
            return;
        }

        UsersSumary user = new UsersSumary();
        user.setId(event.getId());
        user.setFullName(event.getFullName());
        user.setCpf(event.getCpf());
        user.setJobTitle(event.getJobTitle());
        user.setActive(event.getActive());

        usersSumaryRepository.save(user);
    }
}

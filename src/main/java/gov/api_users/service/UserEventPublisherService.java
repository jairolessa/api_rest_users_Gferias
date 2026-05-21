package gov.api_users.service;

import gov.api_users.dto.response.UserCreatedEvent;
import gov.api_users.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserEventPublisherService {

    private final RabbitTemplate rabbitTemplate;

    public void publishUserCreated(Users user) {

        UserCreatedEvent event = new UserCreatedEvent();
        event.setId(user.getId());
        event.setFullName(user.getFullName());
        event.setCpf(user.getCpf());
        event.setJobTitle(user.getJobTitle());
        event.setActive(user.getActive());

        rabbitTemplate.convertAndSend(
                "user.exchange",
                "user.created",
                event
        );
    }
}

package localhost.apacheKafkaProducer.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.CompletableFuture;
import localhost.apacheKafkaProducer.domain.FoodOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

  @Value("${topic.name}")
  private String orderTopic;

  private final ObjectMapper objectMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
    this.kafkaTemplate = kafkaTemplate;
    this.objectMapper = objectMapper;
  }

  public String sendMessage(FoodOrder foodOrder)
      throws JsonProcessingException {
    String orderAsMessage = objectMapper.writeValueAsString(foodOrder);
    CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(
        orderTopic, orderAsMessage);

    log.info("food order produced {}", orderAsMessage);

    return "message sent";
  }
}

package localhost.apacheKafkaProducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import localhost.apacheKafkaProducer.domain.FoodOrder;
import localhost.apacheKafkaProducer.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

  private final Producer producer;

  public FoodOrderService(Producer producer) {
    this.producer = producer;
  }

  public String createFoodOrder(FoodOrder foodOrder)
      throws JsonProcessingException {
    return producer.sendMessage(foodOrder);
  }
}

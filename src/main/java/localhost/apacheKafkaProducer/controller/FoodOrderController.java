package localhost.apacheKafkaProducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import localhost.apacheKafkaProducer.domain.FoodOrder;
import localhost.apacheKafkaProducer.service.FoodOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodOrderController {

  private final FoodOrderService foodOrderService;

  public FoodOrderController(FoodOrderService foodOrderService) {
    this.foodOrderService = foodOrderService;
  }

  @GetMapping("/")
  public String createFoodOrder() throws JsonProcessingException {
    FoodOrder foodOrder = new FoodOrder();
    foodOrder.setItem("item");
    foodOrder.setAmount(2.2);
    return foodOrderService.createFoodOrder(foodOrder);
  }
}

package localhost.apacheKafkaProducer.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrder {

  String item;
  Double amount;
}

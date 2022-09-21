package mall.domain;

import java.util.*;
import lombok.*;
import mall.domain.*;
import mall.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCollectionCompleted extends AbstractEvent {

    private Long id;

    public DeliveryCollectionCompleted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCollectionCompleted() {
        super();
    }
    // keep

}

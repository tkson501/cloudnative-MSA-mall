package mall.domain;

import java.util.*;
import lombok.*;
import mall.domain.*;
import mall.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCollectionStarted extends AbstractEvent {

    private Long id;

    public DeliveryCollectionStarted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCollectionStarted() {
        super();
    }
    // keep

}

package mall.domain;

import java.util.*;
import lombok.*;
import mall.domain.*;
import mall.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private String address;
    private Long productId;
    private String status;
    private Integer qty;

    public DeliveryCompleted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
    // keep

}

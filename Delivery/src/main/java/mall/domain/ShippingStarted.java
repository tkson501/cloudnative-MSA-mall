package mall.domain;

import java.util.*;
import lombok.*;
import mall.domain.*;
import mall.infra.AbstractEvent;

@Data
@ToString
public class ShippingStarted extends AbstractEvent {

    private Long id;

    public ShippingStarted(Delivery aggregate) {
        super(aggregate);
    }

    public ShippingStarted() {
        super();
    }
    // keep

}

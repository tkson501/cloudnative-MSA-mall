package mall.domain;

import java.util.*;
import lombok.*;
import mall.domain.*;
import mall.infra.AbstractEvent;

@Data
@ToString
public class InventoryReduced extends AbstractEvent {

    private Long id;

    public InventoryReduced(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryReduced() {
        super();
    }
    // keep

}

package mall.domain;

import java.util.*;
import lombok.*;
import mall.domain.*;
import mall.infra.AbstractEvent;

@Data
@ToString
public class InventoryIncreased extends AbstractEvent {

    private Long id;

    public InventoryIncreased(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryIncreased() {
        super();
    }
    // keep

}

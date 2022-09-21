package mall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mall.InventoryApplication;
import mall.domain.InventoryIncreased;
import mall.domain.InventoryReduced;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        InventoryReduced inventoryReduced = new InventoryReduced(this);
        inventoryReduced.publishAfterCommit();

        InventoryIncreased inventoryIncreased = new InventoryIncreased(this);
        inventoryIncreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void inventoryReduction(DeliveryCompleted deliveryCompleted) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);


         });
        */

    }

    public static void inventoryIncrease(
        DeliveryCollectionCompleted deliveryCollectionCompleted
    ) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCollectionCompleted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);


         });
        */

    }
}

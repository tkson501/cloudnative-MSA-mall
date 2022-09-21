package mall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mall.DeliveryApplication;
import mall.domain.DeliveryCollectionCompleted;
import mall.domain.DeliveryCollectionStarted;
import mall.domain.DeliveryCompleted;
import mall.domain.ShippingStarted;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private Long productId;

    private String status;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        ShippingStarted shippingStarted = new ShippingStarted(this);
        shippingStarted.publishAfterCommit();

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        DeliveryCollectionCompleted deliveryCollectionCompleted = new DeliveryCollectionCompleted(
            this
        );
        deliveryCollectionCompleted.publishAfterCommit();

        DeliveryCollectionStarted deliveryCollectionStarted = new DeliveryCollectionStarted(
            this
        );
        deliveryCollectionStarted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void shippingStart(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }

    public static void cancelShipping(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
}

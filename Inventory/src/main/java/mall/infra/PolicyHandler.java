package mall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import mall.config.kafka.KafkaProcessor;
import mall.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_InventoryReduction(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener InventoryReduction : " +
            deliveryCompleted +
            "\n\n"
        );

        // Sample Logic //
        Inventory.inventoryReduction(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCollectionCompleted'"
    )
    public void wheneverDeliveryCollectionCompleted_InventoryIncrease(
        @Payload DeliveryCollectionCompleted deliveryCollectionCompleted
    ) {
        DeliveryCollectionCompleted event = deliveryCollectionCompleted;
        System.out.println(
            "\n\n##### listener InventoryIncrease : " +
            deliveryCollectionCompleted +
            "\n\n"
        );

        // Sample Logic //
        Inventory.inventoryIncrease(event);
    }
    // keep

}

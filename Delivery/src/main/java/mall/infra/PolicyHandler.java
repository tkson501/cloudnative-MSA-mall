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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_ShippingStart(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener ShippingStart : " + orderPlaced + "\n\n"
        );

        // Comments //
        //
        // 1. 택배사와 전문교환
        // 2. 고객에게 알림발송
        // 3. 우리 장부에도 저장

        // Sample Logic //
        Delivery.shippingStart(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_CancelShipping(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener CancelShipping : " + orderCanceled + "\n\n"
        );

        // Sample Logic //
        Delivery.cancelShipping(event);
    }
    // keep

}

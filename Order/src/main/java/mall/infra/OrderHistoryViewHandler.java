package mall.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import mall.config.kafka.KafkaProcessor;
import mall.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryViewHandler {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    // keep

}

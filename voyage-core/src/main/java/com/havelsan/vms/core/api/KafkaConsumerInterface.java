package com.havelsan.vms.core.api;

import com.havelsan.vms.data.Constants;
import com.havelsan.vms.data.dao.ShipDao;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumerInterface {

    @KafkaListener(topics= Constants.TOPIC_SHIP_ADD, groupId = Constants.GROUP_ID)
    void listenShipAdd(ShipDao ship);

    @KafkaListener(topics= Constants.TOPIC_SHIP_UPDATE, groupId = Constants.GROUP_ID)
    void listenShipUpdate(ShipDao ship);

    @KafkaListener(topics= Constants.TOPIC_SHIP_DELETE, groupId = Constants.GROUP_ID)
    void listenShipDelete(ShipDao ship);
}

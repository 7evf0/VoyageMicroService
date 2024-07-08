package com.havelsan.vms.core.impl;

import com.havelsan.vms.core.api.KafkaConsumerInterface;
import com.havelsan.vms.data.Constants;
import com.havelsan.vms.data.dao.ShipDao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer implements KafkaConsumerInterface {

    private final KafkaHelper kafkaHelper;

    public KafkaConsumer(KafkaHelper kafkaHelper) {
        this.kafkaHelper = kafkaHelper;
    }

    @KafkaListener(topics= Constants.TOPIC_SHIP_ADD, groupId = Constants.GROUP_ID)
    public void listenShipAdd(ShipDao ship){
       return;
    }

    @KafkaListener(topics= Constants.TOPIC_SHIP_UPDATE, groupId = Constants.GROUP_ID)
    public void listenShipUpdate(ShipDao ship){
        List<String> voyageIds = kafkaHelper.updateRelatedVoyages(ship.getId(), ship);
        System.out.println("\nShip update received on shipId: " + ship.getId() + ". Related voyages with given ID's are updated: " + voyageIds + "\n");
    }

    @KafkaListener(topics= Constants.TOPIC_SHIP_DELETE, groupId = Constants.GROUP_ID)
    public void listenShipDelete(ShipDao ship){
        List<String> voyageIds = kafkaHelper.deleteRelatedVoyages(ship.getId());
        System.out.println("\nShip delete received on shipId: " + ship.getId() + ". Related voyages with given ID's are deleted: " + voyageIds + "\n");
    }

}

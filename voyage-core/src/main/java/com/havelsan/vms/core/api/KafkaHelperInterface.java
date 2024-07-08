package com.havelsan.vms.core.api;

import com.havelsan.vms.data.dao.ShipDao;

import java.util.List;

public interface KafkaHelperInterface {

    List<String> updateRelatedVoyages(String shipId, ShipDao updatedShip);
    List<String> deleteRelatedVoyages(String shipId);
}

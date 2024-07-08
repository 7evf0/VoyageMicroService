package com.havelsan.vms.core.impl;

import com.havelsan.vms.core.api.KafkaHelperInterface;
import com.havelsan.vms.data.dao.ShipDao;
import com.havelsan.vms.data.dao.VoyageDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaHelper implements KafkaHelperInterface {

    private final VoyageService service;

    public KafkaHelper(VoyageService service) {
        this.service = service;
    }

    @Override
    public List<String> updateRelatedVoyages(String shipId, ShipDao updatedShip){
        List<VoyageDao> allVoyages = service.getAllVoyages();
        List<String> voyageIds = new ArrayList<>();

        for(VoyageDao voyage: allVoyages){
            if(voyage.getShipInfo().getId().equals(shipId)){
                voyage.setShipInfo(updatedShip);
                service.updateVoyage(voyage.getId(), voyage);
                voyageIds.add(voyage.getId());
            }
        }

        return voyageIds;
    }

    @Override
    public List<String> deleteRelatedVoyages(String shipId){
        List<VoyageDao> allVoyages = service.getAllVoyages();
        List<String> voyageIds = new ArrayList<>();

        for(VoyageDao voyage: allVoyages){
            if(voyage.getShipInfo().getId().equals(shipId)){
                service.deleteVoyage(voyage.getId());
                voyageIds.add(voyage.getId());
            }
        }

        return voyageIds;
    }
}

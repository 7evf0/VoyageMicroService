package com.havelsan.vms.endpoint.impl;

import com.havelsan.vms.core.impl.ObjectConverter;
import com.havelsan.vms.core.impl.VoyageService;
import com.havelsan.vms.data.dao.ShipDao;
import com.havelsan.vms.data.dao.VoyageDao;
import com.havelsan.vms.data.dto.VoyageDto;
import com.havelsan.vms.endpoint.api.VoyageControllerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api.com.havelsan/vms/v1/voyages")
@ComponentScan(basePackages = {"com.havelsan.vms.core.*"})
public class VoyageController implements VoyageControllerInterface {

    private final VoyageService service;
    private final ObjectConverter objectConverter;

    public VoyageController(VoyageService service, ObjectConverter objectConverter) {
        this.service = service;
        this.objectConverter = objectConverter;
    }

    @Override
    @GetMapping(path="/{voyageNo}")
    public ResponseEntity<VoyageDto> getVoyageById(@PathVariable("voyageNo") String voyageNo){
        VoyageDao voyageDao = service.getVoyageById(voyageNo);
        VoyageDto voyageDto = objectConverter.voyageDaoToVoyageDto(voyageDao);
        return ResponseEntity.ok(voyageDto);
    }

    @Override
    @GetMapping(path = "/")
    public ResponseEntity<List<VoyageDto>> getAllVoyages(){
        List<VoyageDao> voyages = service.getAllVoyages();
        List<VoyageDto> voyageDtoList = new ArrayList<>();
        for(VoyageDao voyage: voyages){
            voyageDtoList.add((objectConverter.voyageDaoToVoyageDto(voyage)));
        }

        return ResponseEntity.ok(voyageDtoList);
    }

    @PostMapping(path = "/")
    public ResponseEntity<VoyageDto> createVoyage(@RequestBody VoyageDto voyage){
        VoyageDto voyageDto = service.addVoyage(voyage);
        return ResponseEntity.ok(voyageDto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<VoyageDto> updateVoyage(@PathVariable("id") String id, @RequestBody VoyageDto voyageDto){
        VoyageDto returnVoyageDto = service.updateVoyage(id, voyageDto);
        return ResponseEntity.ok(returnVoyageDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteVoyage(@PathVariable("id") String id){
        service.deleteVoyage(id);
        return ResponseEntity.noContent().build();
    }

}

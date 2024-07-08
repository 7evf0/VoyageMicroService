package com.havelsan.vms.endpoint.api;

import com.havelsan.vms.data.dao.VoyageDao;
import com.havelsan.vms.data.dto.VoyageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api.com.havelsan/vms/v1/voyages")
public interface VoyageControllerInterface {

    @GetMapping(path="/{voyageNo}")
    public ResponseEntity<VoyageDto> getVoyageById(@PathVariable String voyageNo);

    @GetMapping(path = "/")
    public ResponseEntity<List<VoyageDto>> getAllVoyages();

    @PostMapping(path = "/")
    public ResponseEntity<VoyageDto> createVoyage(@RequestBody VoyageDto voyage);

    @PutMapping(path = "/{id}")
    public ResponseEntity<VoyageDto> updateVoyage(@PathVariable("id") String id, @RequestBody VoyageDto voyage);

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteVoyage(@PathVariable("id") String id);

}

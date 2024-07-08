package com.havelsan.vms.core.api;

import com.havelsan.vms.data.dao.VoyageDao;
import com.havelsan.vms.data.dto.VoyageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoyageServiceInterface {

    VoyageDao getVoyageById(String voyage_no);
    List<VoyageDao> getAllVoyages();

    VoyageDto addVoyage(VoyageDto voyageDto);

    VoyageDto updateVoyage(String voyageId, VoyageDto voyageDto);
    VoyageDao updateVoyage(String voyageId, VoyageDao voyageDao);

    void deleteVoyage(String voyageId);

}

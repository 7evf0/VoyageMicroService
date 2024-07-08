package com.havelsan.vms.core.api;

import com.havelsan.vms.data.dao.CargoDao;
import com.havelsan.vms.data.dao.ShipDao;
import com.havelsan.vms.data.dao.VoyageDao;
import com.havelsan.vms.data.dto.CargoDto;
import com.havelsan.vms.data.dto.ShipDto;
import com.havelsan.vms.data.dto.VoyageDto;

public interface ObjectConverterInterface {

    VoyageDao voyageDtoToVoyageDao(VoyageDto voyageDto);
    VoyageDao voyageDtoToVoyageDao(VoyageDto voyageDto, String id);

    VoyageDto voyageDaoToVoyageDto(VoyageDao voyageDao);

    CargoDto cargoDaoToCargoDto(CargoDao cargoDao);
    CargoDao cargoDtoToCargoDao(CargoDto cargoDto);

    ShipDto shipDaoToShipDto(ShipDao shipDao);
    ShipDao shipDtoToShipDao(ShipDto shipDto);
}

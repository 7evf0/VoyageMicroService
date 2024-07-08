package com.havelsan.vms.core.impl;

import com.havelsan.vms.core.api.ObjectConverterInterface;
import com.havelsan.vms.core.config.exception.ClassNotExistsException;
import com.havelsan.vms.data.dao.CargoDao;
import com.havelsan.vms.data.dao.ShipDao;
import com.havelsan.vms.data.dao.VoyageDao;
import com.havelsan.vms.data.dto.CargoDto;
import com.havelsan.vms.data.dto.ShipDto;
import com.havelsan.vms.data.dto.VoyageDto;
import com.havelsan.vms.repository.ShipRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ObjectConverter implements ObjectConverterInterface {

    private final ShipRepository shipRepository;

    public ObjectConverter(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public CargoDto cargoDaoToCargoDto(CargoDao cargoDao){
        CargoDto cargoDto = new CargoDto();

        cargoDto.setCargoAmount(cargoDao.getCargoAmount());
        cargoDto.setCargoName(cargoDao.getCargoName());
        cargoDto.setCargoUnit(cargoDao.getCargoUnit());
        return cargoDto;
    }

    @Override
    public CargoDao cargoDtoToCargoDao(CargoDto cargoDto){
        CargoDao cargoDao = new CargoDao();

        cargoDao.setCargoAmount(cargoDto.getCargoAmount());
        cargoDao.setCargoName(cargoDto.getCargoName());
        cargoDao.setCargoUnit(cargoDto.getCargoUnit());

        return cargoDao;
    }

    @Override
    public ShipDto shipDaoToShipDto(ShipDao shipDao){
        ShipDto shipDto = new ShipDto();

        shipDto.setId(shipDao.getId());
        shipDto.setBreadth(shipDao.getBreadth());
        shipDto.setCallSign(shipDao.getCallSign());
        shipDto.setFlag(shipDao.getFlag());
        shipDto.setDraught(shipDao.getDraught());
        shipDto.setMmsi(shipDao.getMmsi());
        shipDto.setLength(shipDao.getLength());
        shipDto.setConstructionYear(shipDao.getConstructionYear());
        shipDto.setDeadWeightTonnage(shipDao.getDeadWeightTonnage());
        shipDto.setGrossTonnage(shipDao.getGrossTonnage());
        shipDto.setImoNo(shipDao.getImoNo());
        shipDto.setNetTonnage(shipDao.getNetTonnage());
        shipDto.setMaxSpeed(shipDao.getMaxSpeed());
        shipDto.setName(shipDao.getName());
        shipDto.setType(shipDao.getType());

        return shipDto;
    }

    @Override
    public ShipDao shipDtoToShipDao(ShipDto shipDto){
        ShipDao shipDao = new ShipDao();

        shipDao.setId(shipDto.getId());
        shipDao.setBreadth(shipDto.getBreadth());
        shipDao.setCallSign(shipDto.getCallSign());
        shipDao.setFlag(shipDto.getFlag());
        shipDao.setDraught(shipDto.getDraught());
        shipDao.setMmsi(shipDto.getMmsi());
        shipDao.setLength(shipDto.getLength());
        shipDao.setConstructionYear(shipDto.getConstructionYear());
        shipDao.setDeadWeightTonnage(shipDto.getDeadWeightTonnage());
        shipDao.setGrossTonnage(shipDto.getGrossTonnage());
        shipDao.setImoNo(shipDto.getImoNo());
        shipDao.setNetTonnage(shipDto.getNetTonnage());
        shipDao.setMaxSpeed(shipDto.getMaxSpeed());
        shipDao.setName(shipDto.getName());
        shipDao.setType(shipDto.getType());

        return shipDao;
    }

    @Override
    public VoyageDao voyageDtoToVoyageDao(VoyageDto voyageDto) {
        VoyageDao voyageDao = new VoyageDao();

        voyageDao.setCaptainName(voyageDto.getCaptainName());

        List<CargoDao> cargoDaoList = new ArrayList<>();
        List<CargoDto> cargoDtoList = voyageDto.getCargoList();
        if (cargoDtoList != null) {
            for(CargoDto cargo : voyageDto.getCargoList()){
                CargoDao cargoDao = cargoDtoToCargoDao(cargo);
                cargoDaoList.add(cargoDao);
            }
            voyageDao.setCargoList(cargoDaoList);
        }

        voyageDao.setCrewCount(voyageDto.getCrewCount());
        voyageDao.setDeparturePortName(voyageDto.getDeparturePortName());
        voyageDao.setDestinationPortName(voyageDto.getDestinationPortName());

        // GET SHIP INFO WITH SHIP ID
        Optional<ShipDao> shipDaoOptional = shipRepository.findById(voyageDto.getShipId());

        if(shipDaoOptional.isPresent()){
            ShipDao shipDao = shipDaoOptional.get();
            voyageDao.setShipInfo(shipDao);
        }
        else{
            throw new ClassNotExistsException("Cannot find ship with id: " + voyageDto.getShipId());
        }

        return voyageDao;
    }

    @Override
    public VoyageDao voyageDtoToVoyageDao(VoyageDto voyageDto, String id) {
        VoyageDao voyageDao = new VoyageDao();

        voyageDao.setId(id);
        voyageDao.setCaptainName(voyageDto.getCaptainName());

        List<CargoDao> cargoDaoList = new ArrayList<>();
        List<CargoDto> cargoDtoList = voyageDto.getCargoList();
        if (cargoDtoList != null) {
            for(CargoDto cargo : voyageDto.getCargoList()){
                CargoDao cargoDao = cargoDtoToCargoDao(cargo);
                cargoDaoList.add(cargoDao);
            }
            voyageDao.setCargoList(cargoDaoList);
        }

        voyageDao.setCrewCount(voyageDto.getCrewCount());
        voyageDao.setDeparturePortName(voyageDto.getDeparturePortName());
        voyageDao.setDestinationPortName(voyageDto.getDestinationPortName());

        // GET SHIP INFO WITH SHIP ID
        Optional<ShipDao> shipDaoOptional = shipRepository.findById(voyageDto.getShipId());

        if(shipDaoOptional.isPresent()){
            ShipDao shipDao = shipDaoOptional.get();
            voyageDao.setShipInfo(shipDao);
        }
        else{
            throw new ClassNotExistsException("Cannot find ship with id: " + id);
        }

        return voyageDao;
    }

    public VoyageDto voyageDaoToVoyageDto(VoyageDao voyageDao){
        VoyageDto voyageDto = new VoyageDto();

        voyageDto.setId(voyageDao.getId());
        voyageDto.setCaptainName(voyageDao.getCaptainName());

        List<CargoDto> cargoDtoList = new ArrayList<>();
        List<CargoDao> cargoDaoList = voyageDao.getCargoList();
        if (cargoDaoList != null) {
            for(CargoDao cargo : voyageDao.getCargoList()){
                CargoDto cargoDto = cargoDaoToCargoDto(cargo);
                cargoDtoList.add(cargoDto);
            }
            voyageDto.setCargoList(cargoDtoList);
        }

        voyageDto.setCrewCount(voyageDao.getCrewCount());
        voyageDto.setDeparturePortName(voyageDao.getDeparturePortName());
        voyageDto.setDestinationPortName(voyageDao.getDestinationPortName());

        voyageDto.setShipId(voyageDao.getShipInfo().getId());

        ShipDto shipDto = shipDaoToShipDto(voyageDao.getShipInfo());
        voyageDto.setShipInfo(shipDto);

        return voyageDto;
    }

}

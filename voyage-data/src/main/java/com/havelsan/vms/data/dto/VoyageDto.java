package com.havelsan.vms.data.dto;

import java.util.List;

public class VoyageDto {

    private String id;
    private String shipId;

    private ShipDto shipInfo;

    private String departurePortName;
    private String destinationPortName;

    private List<CargoDto> cargoList;

    private String captainName;
    private Integer crewCount;

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getDeparturePortName() {
        return departurePortName;
    }

    public void setDeparturePortName(String departurePortName) {
        this.departurePortName = departurePortName;
    }

    public String getDestinationPortName() {
        return destinationPortName;
    }

    public void setDestinationPortName(String destinationPortName) {
        this.destinationPortName = destinationPortName;
    }

    public List<CargoDto> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<CargoDto> cargoList) {
        this.cargoList = cargoList;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public Integer getCrewCount() {
        return crewCount;
    }

    public void setCrewCount(Integer crewCount) {
        this.crewCount = crewCount;
    }

    public ShipDto getShipInfo() {
        return shipInfo;
    }

    public void setShipInfo(ShipDto shipInfo) {
        this.shipInfo = shipInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

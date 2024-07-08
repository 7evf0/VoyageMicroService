package com.havelsan.vms.data.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Voyage")
public class VoyageDao {

    @Id
    private String id;

    private ShipDao shipInfo;

    private String departurePortName;
    private String destinationPortName;

    private List<CargoDao> cargoList;

    private String captainName;
    private Integer crewCount;

    public ShipDao getShipInfo() {
        return shipInfo;
    }

    public void setShipInfo(ShipDao shipInfo) {
        this.shipInfo = shipInfo;
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

    public List<CargoDao> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<CargoDao> cargoList) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

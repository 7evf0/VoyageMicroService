package com.havelsan.vms.data.dto;

public class ShipDto {

    private String id;
    private String imoNo;
    private String mmsi;
    private String name;
    private String type;
    private Short constructionYear;
    private Float breadth;
    private Float deadWeightTonnage;
    private String draught;
    private Float length;
    private Float grossTonnage;
    private Float netTonnage;
    private String callSign;
    private String flag;
    private Float maxSpeed;

    public String getImoNo() {
        return imoNo;
    }

    public void setImoNo(String imoNo) {
        this.imoNo = imoNo;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Short constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Float getBreadth() {
        return breadth;
    }

    public void setBreadth(Float breadth) {
        this.breadth = breadth;
    }

    public Float getDeadWeightTonnage() {
        return deadWeightTonnage;
    }

    public void setDeadWeightTonnage(Float deadWeightTonnage) {
        this.deadWeightTonnage = deadWeightTonnage;
    }

    public String getDraught() {
        return draught;
    }

    public void setDraught(String draught) {
        this.draught = draught;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getGrossTonnage() {
        return grossTonnage;
    }

    public void setGrossTonnage(Float grossTonnage) {
        this.grossTonnage = grossTonnage;
    }

    public Float getNetTonnage() {
        return netTonnage;
    }

    public void setNetTonnage(Float netTonnage) {
        this.netTonnage = netTonnage;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

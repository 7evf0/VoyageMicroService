package com.havelsan.vms.data.dto;

public class CargoDto {

        private String cargoName;
        private String cargoUnit;
        private Integer cargoAmount;

        public String getCargoName() {
                return cargoName;
        }

        public void setCargoName(String cargoName) {
                this.cargoName = cargoName;
        }

        public String getCargoUnit() {
                return cargoUnit;
        }

        public void setCargoUnit(String cargoUnit) {
                this.cargoUnit = cargoUnit;
        }

        public Integer getCargoAmount() {
                return cargoAmount;
        }

        public void setCargoAmount(Integer cargoAmount) {
                this.cargoAmount = cargoAmount;
        }
}

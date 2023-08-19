package DesignParkingLot.Model;

import DesignParkingLot.Enum.VehicleType;

public class Vehicle {
    String registrationNumber;
    String color;
    VehicleType vehicleType;
    public Vehicle(String registrationNumber, String color, String type) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        if(type.equalsIgnoreCase(VehicleType.BIKE.toString())) {
            this.vehicleType = VehicleType.BIKE;
        } else if(type.equalsIgnoreCase(VehicleType.CAR.toString())) {
            this.vehicleType = VehicleType.CAR;
        } else if(type.equalsIgnoreCase(VehicleType.TRUCK.toString())) {
            this.vehicleType = VehicleType.TRUCK;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}

package DesignParkingLot.Model;

import DesignParkingLot.Enum.ParkingSlotStatus;
import DesignParkingLot.Enum.VehicleType;

public class ParkingSlot {
    Integer parkingSlotId;
    ParkingSlotStatus parkingSlotStatus;
    VehicleType vehicleType;
    Vehicle vehicle;
    public ParkingSlot(Integer parkingSlotId, String vehicleType) {
        this.parkingSlotId = parkingSlotId;
        this.parkingSlotStatus = ParkingSlotStatus.AVAILABLE;
        if(vehicleType.equalsIgnoreCase(VehicleType.BIKE.toString())) {
            this.vehicleType = VehicleType.BIKE;
        } else if(vehicleType.equalsIgnoreCase(VehicleType.CAR.toString())) {
            this.vehicleType = VehicleType.CAR;
        } else if(vehicleType.equalsIgnoreCase(VehicleType.TRUCK.toString())) {
            this.vehicleType = VehicleType.TRUCK;
        }
    }

    public Integer getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(Integer parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "parkingSlotId=" + parkingSlotId +
                ", parkingSlotStatus=" + parkingSlotStatus +
                ", vehicleType=" + vehicleType +
                ", vehicle=" + vehicle +
                '}';
    }
}

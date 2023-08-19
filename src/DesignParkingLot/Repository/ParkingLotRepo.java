package DesignParkingLot.Repository;

import DesignParkingLot.Model.ParkingFloor;
import DesignParkingLot.Model.ParkingSlot;
import DesignParkingLot.Model.Ticket;
import DesignParkingLot.Model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepo {
    Map<Integer, ParkingFloor> parkingFloorMap = new HashMap<>();
    Map<Integer, ParkingSlot> parkingSlotMap = new HashMap<>();
    Map<String, Vehicle> vehicleMap = new HashMap<>();
    Map<String, Ticket> ticketMap = new HashMap<>();

    public Map<Integer, ParkingFloor> getParkingFloorMap() {
        return parkingFloorMap;
    }

    public void setParkingFloorMap(Map<Integer, ParkingFloor> parkingFloorMap) {
        this.parkingFloorMap = parkingFloorMap;
    }

    public Map<Integer, ParkingSlot> getParkingSlotMap() {
        return parkingSlotMap;
    }

    public void setParkingSlotMap(Map<Integer, ParkingSlot> parkingSlotMap) {
        this.parkingSlotMap = parkingSlotMap;
    }

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }
}

package DesignParkingLot.Model;

import DesignParkingLot.Enum.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<ParkingFloor> parkingFloorList;
    String parkingLotId;
    Integer totalNumberOfFloors;
    Map<Integer, ParkingFloor> parkingFloorMap = new HashMap<>();
    Map<Integer, ParkingSlot> parkingSlotMap = new HashMap<>();
    Map<String, Vehicle> vehicleMap = new HashMap<>();
    Map<String, Ticket> ticketMap = new HashMap<>();
    public ParkingLot(Integer numberOfFloor, String parkingLotId) {
        this.parkingFloorList = new ArrayList<ParkingFloor>();
        this.parkingLotId = parkingLotId;
        this.totalNumberOfFloors = numberOfFloor;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getTotalNumberOfFloors() {
        return totalNumberOfFloors;
    }

    public void setTotalNumberOfFloors(Integer totalNumberOfFloors) {
        this.totalNumberOfFloors = totalNumberOfFloors;
    }

    public void addFloorToLot(ParkingFloor parkingFloor) {
        this.parkingFloorList.add(parkingFloor);
    }

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

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingFloorList=" + parkingFloorList +
                ", parkingLotId='" + parkingLotId + '\'' +
                ", totalNumberOfFloors=" + totalNumberOfFloors +
                '}';
    }
}

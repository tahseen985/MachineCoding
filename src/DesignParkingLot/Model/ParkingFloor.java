package DesignParkingLot.Model;

import DesignParkingLot.Enum.VehicleType;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    Integer floorNumber;
    List<ParkingSlot> parkingSlotList;
    Integer totalNumberOfSlot;
    public ParkingFloor(Integer floorNumber) {
        this.parkingSlotList = new ArrayList<ParkingSlot>();
        this.floorNumber = floorNumber;
    }

    // vehicle type

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public Integer getTotalNumberOfSlot() {
        return totalNumberOfSlot;
    }

    public void setTotalNumberOfSlot(Integer totalNumberOfSlot) {
        this.totalNumberOfSlot = totalNumberOfSlot;
    }

    public void addSlotToFloor(ParkingSlot parkingSlot) {
        this.parkingSlotList.add(parkingSlot);
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "floorNumber=" + floorNumber +
                ", parkingSlotList=" + parkingSlotList +
                ", totalNumberOfSlot=" + totalNumberOfSlot +
                '}';
    }
}

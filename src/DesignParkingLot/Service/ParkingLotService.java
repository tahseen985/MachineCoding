package DesignParkingLot.Service;

import DesignParkingLot.Enum.ParkingSlotStatus;
import DesignParkingLot.Enum.VehicleType;
import DesignParkingLot.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
floor
slot type, type, type
 */

public class ParkingLotService {

    public void  addFloorToParkingLot(ParkingLot parkingLot, ParkingFloor parkingFloor) {
        parkingLot.addFloorToLot(parkingFloor);
        parkingLot.getParkingFloorMap().put(parkingFloor.getFloorNumber(), parkingFloor);
    }
    public void addSlotToFloor(ParkingLot parkingLot, Integer floorNumber, ParkingSlot parkingSlot) {
        parkingLot.getParkingFloorMap().get(floorNumber).addSlotToFloor(parkingSlot);
        parkingLot.getParkingSlotMap().put(parkingSlot.getParkingSlotId(), parkingSlot);
    }

    public void addVehicleToMap(Vehicle vehicle, ParkingLot parkingLot) {
        parkingLot.getVehicleMap().put(vehicle.getRegistrationNumber(), vehicle);
    }

    /*
    floor -> count -> car, bike, truck
    map<Int, map<Enum, Int>> map
    map<Int, map<Enum, priorityQueue>>
     */
    public Ticket parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        Ticket ticket = null;
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();
        for (ParkingFloor parkingFloor : parkingFloorList) {
            List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
            for (ParkingSlot parkingSlot : parkingSlotList) {
                if(parkingSlot.getVehicleType().toString().equalsIgnoreCase(vehicle.getVehicleType().toString())
                && parkingSlot.getParkingSlotStatus().toString().equalsIgnoreCase(ParkingSlotStatus.AVAILABLE.toString())) {
                    parkingSlot.setParkingSlotStatus(ParkingSlotStatus.NOT_AVAILABLE);
                    parkingSlot.setVehicle(vehicle);
                    ticket = new Ticket(parkingLot.getParkingLotId(), parkingFloor.getFloorNumber(), parkingSlot.getParkingSlotId());
                    break;
                }
            }
            if(ticket != null) break;
        }
        if(ticket != null) {
            parkingLot.getTicketMap().put(ticket.getTicketId(),  ticket);
            System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicketId());
        } else {
            System.out.println("Parking Lot Full");
        }
        return ticket;
    }

    public void unParkVehicle(String ticketId, ParkingLot parkingLot) {
        Map<String, Ticket> map = parkingLot.getTicketMap();
        if(!map.containsKey(ticketId)) {
            System.out.println("Invalid Ticket, Please try again");
            return;
        }
        Ticket ticket = map.get(ticketId);
        ParkingSlot parkingSlot = parkingLot.getParkingSlotMap().get(ticket.getSlotNumber()-1);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        Vehicle vehicle = parkingSlot.getVehicle();
        parkingSlot.setVehicle(null);
        System.out.println("Un parked vehicle with Registration Number: " +  vehicle.getRegistrationNumber()
                + " and Color: "  + vehicle.getColor());
        map.remove(ticketId);
    }

    public void displayFreeCountsFloorWise(ParkingLot parkingLot) {
        int car;
        int bike;
        int truck;
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();
        for(int i=0; i<parkingFloorList.size(); i++) {
            ParkingFloor parkingFloor = parkingFloorList.get(i);
            List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
            car = 0;
            bike = 0;
            truck = 0;
            for(ParkingSlot parkingSlot : parkingSlotList) {
                // check
                if(parkingSlot.getParkingSlotStatus().toString().equalsIgnoreCase(ParkingSlotStatus.AVAILABLE.toString())) {
                    if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("car")) {
                        car++;
                    } else if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("bike")) {
                        bike++;
                    } else if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("truck")) {
                        truck++;
                    }
                }
            }
            int floorNumber = i+1;
            System.out.println("No. of free slots for " + VehicleType.CAR.name() + " on Floor " + floorNumber + ":" + car);
            System.out.println("No. of free slots for " + VehicleType.BIKE.name() + " on Floor " + floorNumber + ":" + bike);
            System.out.println("No. of free slots for " + VehicleType.TRUCK.name() + " on Floor " + floorNumber + ":" + truck);
        }
    }

    public void displayFreeSlotsFloorWise(ParkingLot parkingLot) {
        List<Integer> carList;
        List<Integer> bikeList;
        List<Integer> truckList;
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();
        for(int i=0; i<parkingFloorList.size(); i++) {
            ParkingFloor parkingFloor = parkingFloorList.get(i);
            List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
            carList = new ArrayList<>();
            bikeList = new ArrayList<>();
            truckList = new ArrayList<>();
            for(ParkingSlot parkingSlot : parkingSlotList) {
                if(parkingSlot.getParkingSlotStatus().toString().equalsIgnoreCase(ParkingSlotStatus.AVAILABLE.toString())) {
                    if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("car")) {
                        carList.add(parkingSlot.getParkingSlotId());
                    } else if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("bike")) {
                        bikeList.add(parkingSlot.getParkingSlotId());
                    } else if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("truck")) {
                        truckList.add(parkingSlot.getParkingSlotId());
                    }
                }
            }
            int floorNumber = i+1;
            System.out.println("Free slots for " + VehicleType.CAR + " on Floor " + floorNumber + ":" + carList);
            System.out.println("Free slots for " + VehicleType.BIKE + " on Floor " + floorNumber + ":" + bikeList);
            System.out.println("Free slots for " + VehicleType.TRUCK + " on Floor " + floorNumber + ":" + truckList);
        }
    }

    public void displayOccupiedSlotsFloorWise(ParkingLot parkingLot) {
        List<Integer> carList;
        List<Integer> bikeList;
        List<Integer> truckList;
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();
        for(int i=0; i<parkingFloorList.size(); i++) {
            ParkingFloor parkingFloor = parkingFloorList.get(i);
            List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
            carList = new ArrayList<>();
            bikeList = new ArrayList<>();
            truckList = new ArrayList<>();
            for(ParkingSlot parkingSlot : parkingSlotList) {
                if(parkingSlot.getParkingSlotStatus().toString().equalsIgnoreCase(ParkingSlotStatus.NOT_AVAILABLE.toString())) {
                    if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("car")) {
                        carList.add(parkingSlot.getParkingSlotId());
                    } else if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("bike")) {
                        bikeList.add(parkingSlot.getParkingSlotId());
                    } else if(parkingSlot.getVehicleType().toString().equalsIgnoreCase("truck")) {
                        truckList.add(parkingSlot.getParkingSlotId());
                    }
                }
            }
            int floorNumber = i+1;
            System.out.println("Occupied slots for " + VehicleType.CAR + " on Floor " + floorNumber + ":" + carList);
            System.out.println("Occupied slots for " + VehicleType.BIKE + " on Floor " + floorNumber + ":" + bikeList);
            System.out.println("Occupied slots for " + VehicleType.TRUCK + " on Floor " + floorNumber + ":" + truckList);
        }
    }
}

/*
1 -> controller
2 -> service
3 -> model
4 -> enum
 */

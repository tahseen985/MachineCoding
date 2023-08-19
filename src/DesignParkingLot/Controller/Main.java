package DesignParkingLot.Controller;

import DesignParkingLot.Model.*;
import DesignParkingLot.Service.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        Integer numberOfFloor = 2;
        Integer numberOfSlot = 3;
        String parkingLotId = "12345";
        String car = "car";
        String bike = "bike";
        String truck = "truck";

        ParkingLot parkingLot = new ParkingLot(numberOfFloor, parkingLotId);

        ParkingFloor parkingFloor1 = new ParkingFloor(1);
        ParkingFloor parkingFloor2 = new ParkingFloor(2);
        parkingLotService.addFloorToParkingLot(parkingLot, parkingFloor1);
        parkingLotService.addFloorToParkingLot(parkingLot, parkingFloor2);

        ParkingSlot parkingSlot1 = new ParkingSlot(1, car);
        ParkingSlot parkingSlot2 = new ParkingSlot(2, bike);
        ParkingSlot parkingSlot3 = new ParkingSlot(3, truck);

        ParkingSlot parkingSlot4 = new ParkingSlot(4, car);
        ParkingSlot parkingSlot5 = new ParkingSlot(5, bike);
        ParkingSlot parkingSlot6 = new ParkingSlot(6, truck);

        parkingLotService.addSlotToFloor(parkingLot, parkingFloor1.getFloorNumber(), parkingSlot1);
        parkingLotService.addSlotToFloor(parkingLot, parkingFloor1.getFloorNumber(), parkingSlot2);
        parkingLotService.addSlotToFloor(parkingLot, parkingFloor1.getFloorNumber(), parkingSlot3);

        parkingLotService.addSlotToFloor(parkingLot, parkingFloor2.getFloorNumber(), parkingSlot4);
        parkingLotService.addSlotToFloor(parkingLot, parkingFloor2.getFloorNumber(), parkingSlot5);
        parkingLotService.addSlotToFloor(parkingLot, parkingFloor2.getFloorNumber(), parkingSlot6);

        System.out.println("Created parking lot with " + numberOfFloor + " floors and " +  numberOfSlot +
                " slots per floor");

        Vehicle vehicle1 = new Vehicle("BR1P5053", "white", "Bike");
        Vehicle vehicle2 = new Vehicle("BR1P5056", "black", "Bike");
        Vehicle vehicle3 = new Vehicle("BR1P5059", "blue", "Bike");

        parkingLotService.addVehicleToMap(vehicle1, parkingLot);
        parkingLotService.addVehicleToMap(vehicle2, parkingLot);
        parkingLotService.addVehicleToMap(vehicle3, parkingLot);


        Ticket ticket1 = parkingLotService.parkVehicle(vehicle1, parkingLot);
        Ticket ticket2 = parkingLotService.parkVehicle(vehicle2, parkingLot);
        Ticket ticket3 = parkingLotService.parkVehicle(vehicle3, parkingLot);


        parkingLotService.unParkVehicle("?????", parkingLot);
        parkingLotService.displayFreeCountsFloorWise(parkingLot);
        parkingLotService.displayFreeSlotsFloorWise(parkingLot);
        parkingLotService.displayOccupiedSlotsFloorWise(parkingLot);
        parkingLotService.unParkVehicle(ticket2.getTicketId(), parkingLot);
        parkingLotService.displayFreeCountsFloorWise(parkingLot);
        parkingLotService.displayFreeSlotsFloorWise(parkingLot);
        parkingLotService.displayOccupiedSlotsFloorWise(parkingLot);
        ticket3 = parkingLotService.parkVehicle(vehicle3, parkingLot);
        parkingLotService.displayFreeCountsFloorWise(parkingLot);
        parkingLotService.displayFreeSlotsFloorWise(parkingLot);
        parkingLotService.displayOccupiedSlotsFloorWise(parkingLot);
        parkingLotService.unParkVehicle(ticket3.getTicketId(), parkingLot);
    }
}

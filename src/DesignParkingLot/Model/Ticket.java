package DesignParkingLot.Model;

public class Ticket {
    String ticketId;
    String parkingLotId;
    Integer floorNumber;
    Integer slotNumber;
    public Ticket(String parkingLotId, Integer floorNumber, Integer slotNumber) {
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.ticketId = this.parkingLotId + "_" + this.floorNumber.toString() + "_" + this.slotNumber.toString();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", parkingLotId='" + parkingLotId + '\'' +
                ", floorNumber=" + floorNumber +
                ", slotNumber=" + slotNumber +
                '}';
    }
}

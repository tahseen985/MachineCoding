package DesignLibraryManagmentSystem.Model;

import DesignLibraryManagmentSystem.Enum.RackStatus;

public class Rack {
    Integer rackNumber;
    RackStatus rackStatus;

    public Rack(Integer rackNumber, String status) {
        this.rackNumber = rackNumber;
        if(status.equalsIgnoreCase(RackStatus.FREE.toString())) {
            this.rackStatus = RackStatus.FREE;
        } else {
            this.rackStatus = RackStatus.OCCUPIED;
        }
    }

    public Integer getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(Integer rackNumber) {
        this.rackNumber = rackNumber;
    }

    public RackStatus getRackStatus() {
        return rackStatus;
    }

    public void setRackStatus(RackStatus rackStatus) {
        this.rackStatus = rackStatus;
    }

    @Override
    public String toString() {
        return "Rack{" +
                "rackNumber=" + rackNumber +
                ", rackStatus=" + rackStatus +
                '}';
    }
}

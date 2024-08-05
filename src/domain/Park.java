package domain;

import java.time.LocalDateTime;

public class Park {
    private int parking_slot_id;
    private int car_id;
    private Is_parked is_parked;
    private ParkingType parkingType;
    private ParkableSize parkableSize;
    private LocalDateTime entranceTime;
    private LocalDateTime departureTime;

    public Park() {}

    public int getParking_slot_id() {
        return parking_slot_id;
    }

    public void setParking_slot_id(int parking_slot_id) {
        this.parking_slot_id = parking_slot_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public Is_parked getIs_parked() {
        return is_parked;
    }

    public void setIs_parked(Is_parked is_parked) {
        this.is_parked = is_parked;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public ParkableSize getParkableSize() {
        return parkableSize;
    }

    public void setParkableSize(ParkableSize parkableSize) {
        this.parkableSize = parkableSize;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Park{" + "parking_slot_id=" + parking_slot_id + ", car_id=" + car_id + ", is_parked=" + is_parked +
               ", parkingType=" + parkingType + ", parkableSize=" + parkableSize + ", entranceTime=" + entranceTime +
               ", departureTime=" + departureTime + '}';
    }
}

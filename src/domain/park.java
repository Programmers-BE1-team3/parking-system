package domain;

import java.time.LocalDateTime;

public class Park {
    private int parking_slot_id;
    private Is_parked is_parked;
    private ParkingType parkingType;
    private ParkableSize parkableSize;
    private LocalDateTime entranceTime;
    private LocalDateTime departureTime;

    public Park(int parking_slot_id, Is_parked is_parked, ParkingType parkingType, ParkableSize parkableSize, LocalDateTime entranceTime, LocalDateTime departureTime) {
        this.parking_slot_id = parking_slot_id;
        this.is_parked = is_parked;
        this.parkingType = parkingType;
        this.parkableSize = parkableSize;
        this.entranceTime = entranceTime;
        this.departureTime = departureTime;
    }

    public int getParking_slot_id() {
        return parking_slot_id;
    }

    public Is_parked getIs_parked() {
        return is_parked;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public ParkableSize getParkableSize() {
        return parkableSize;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
}

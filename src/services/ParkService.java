package services;

import domain.Car;
import domain.Park;
import exceptions.NoExistParkingSlotException;

public interface ParkService {
    void showParkingInfo();
    Park entrance(Car car, int parking_slot_id) throws NoExistParkingSlotException;
    Park departure(int parkingSlotId) throws NoExistParkingSlotException;
}

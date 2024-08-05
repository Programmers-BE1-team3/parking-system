package repositories;

import domain.Car;
import domain.Park;

import java.util.List;

public interface ParkRepository {
    int update(Car car, int parking_slot_id);
    int updateEntrance(Park park);
    int updateExit(Park park);
    Park selectBySlotId(int id);
    List<Park> selectAll();
}

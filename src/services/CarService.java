package services;

import domain.Car;

public interface CarService {
    boolean register(Car car);
    Car findCar(int user_id);
}

package repositories;

import domain.Car;

import java.util.List;

public interface CarRepository {
    int insert(Car car);
    int update(int id);
    Car select();
    List<Car> selectall();

}

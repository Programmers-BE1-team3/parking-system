package repositories;

import domain.Car;

import java.util.List;

public interface CarRepository {
    int insert();
    int update(int id);
    Car select();
    List<Car> selectall();

}

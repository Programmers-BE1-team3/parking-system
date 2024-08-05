package repositories;

public interface CarRepository {
    int insert();
    int update(int id);
    Car select();
    List<Car> selectAll();

}

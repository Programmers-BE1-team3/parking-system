package repositories;

public interface ParkRepository {

    int insert(Car car);
    List<AllParkInfo> selectAll();
    int updateIsParked();

}

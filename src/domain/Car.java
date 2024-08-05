package domain;

public class Car {
    private static int car_id;
    private String car_num;
    private CarType car_type;
    public Car(String car_num, CarType car_type) {
        this.car_num = car_num;
        this.car_type = car_type;
    }

}

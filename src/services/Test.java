package services;

import domain.Car;
import domain.ParkableSize;
import exceptions.NoExistParkingSlotException;

public class Test {
}

class TestParkServiceImpl {
    public static void main(String[] args) {
        TestParkServiceImpl test = new TestParkServiceImpl();
        ParkService service = new ParkServiceImpl();

        // 현재 존재하는 주차 가능 칸 보여주기
        service.showParkingInfo();


        // car_id 11 인 차를 1 번 주차 자리에 입차시킴
        Car car = new Car();
        car.setCar_id(11);
        car.setCar_type(ParkableSize.SMALL);

        try {
            service.entrance(car, 1 );
        }

        // 해당 주차 칸이 이미 주차되 있거나,
        // 주차하려는 차가 parkable_size 보다 크거나,
        // 해당하는 parking_slot_id 를 못찾았을 때 에러
        catch (NoExistParkingSlotException e) {
            System.out.println("현재 자리에 주어진 car 못넣음");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            service.departure(1);
        }
        
        // 해당하는 parking_slot_id 를 못찾았을 때 에러
        catch (NoExistParkingSlotException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

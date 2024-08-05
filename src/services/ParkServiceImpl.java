package services;

import domain.Car;
import domain.Park;
import domain.ParkableSize;
import exceptions.NoExistParkingSlotException;
import repositories.ParkRepository;
import repositories.ParkRepositoryImpl;

import java.util.List;
import java.util.function.Predicate;

public class ParkServiceImpl implements ParkService {

    private static final ParkRepository repo = ParkRepositoryImpl.getInstance();

    @Override
    public void showParkingInfo() {
        List<Park> list = repo.selectAll();

        Predicate<Park> parkAble = p -> !p.getIs_parked().getB();

        List<Park> emptySlots = list.parallelStream()
                                    .filter(parkAble)
                                    .toList();

        System.out.printf("현재 %2d 자리가 주차 가능합니다.\n", emptySlots.size());

        if (emptySlots.isEmpty())   return;

        List<Park> smallSlots = emptySlots.stream()
                                          .filter(p -> p.getParkableSize() == ParkableSize.SMALL)
                                          .toList();

        List<Park> mediumSlots = emptySlots.stream()
                                           .filter(p -> p.getParkableSize() == ParkableSize.MEDIUM)
                                           .toList();

        List<Park> largeSlots = emptySlots.stream()
                                          .filter(p -> p.getParkableSize() == ParkableSize.LARGE)
                                          .toList();

        if (!smallSlots.isEmpty())  {
            System.out.printf("\t소형 \t: %2d 자리 - \t[", smallSlots.size());
            for (Park park : smallSlots)
                System.out.printf("%2d, ", park.getParking_slot_id());
            System.out.println("] 번칸 사용 가능");
        }

        if (!mediumSlots.isEmpty())  {
            System.out.printf("\t중형 \t: %2d 자리 - \t[", mediumSlots.size());
            for (Park park : mediumSlots)
                System.out.printf("%2d, ", park.getParking_slot_id());
            System.out.println("] 번칸 사용 가능");
        }

        if (!largeSlots.isEmpty())  {
            System.out.printf("\t대형 \t: %2d 자리 - \t[", largeSlots.size());
            for (Park park : largeSlots)
                System.out.printf("%2d, ", park.getParking_slot_id());
            System.out.println("] 번칸 사용 가능");
        }
    }

    @Override
    public Park entrance(Car car, int parking_slot_id) throws NoExistParkingSlotException {
        Park p = repo.selectBySlotId(parking_slot_id);

        if (p == null
            || p.getParkableSize() != car.getCar_type()
            || p.getIs_parked().getB())
            throw new NoExistParkingSlotException(parking_slot_id);

        p.setCar_id(car.getCar_id());
        repo.updateEntrance(p);

        return repo.selectBySlotId(parking_slot_id);
    }

    @Override
    public Park departure(int parkingSlotId) throws NoExistParkingSlotException {
        Park p = repo.selectBySlotId(parkingSlotId);

        if (p == null)
            throw new NoExistParkingSlotException(parkingSlotId);

        repo.updateExit(p);

        return repo.selectBySlotId(parkingSlotId);
    }
}

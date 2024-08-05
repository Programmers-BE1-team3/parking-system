package repositories;

import domain.Park;

import java.util.List;

public class Test {
}

class TestParkRepositoryImpl {
    public static void main(String[] args) {
        TestParkRepositoryImpl test = new TestParkRepositoryImpl();
        ParkRepository repo = ParkRepositoryImpl.getInstance();

        // 현재 존재하는 주차 칸 표시
        test.testSelectAll(repo);

        // 임의로 첫번째 주차 칸 선택
        Park p = repo.selectBySlotId(1);

        // 1 번 주차칸에 입차
        test.testUpdateEntrance(repo, p);

        // 1 번 주차칸에서 출차
        test.testUpdateExit(repo, p);
    }

    void testSelectAll(ParkRepository repo) {
        List<Park> list = repo.selectAll();

        for (Park p : list)
            System.out.println(p);
    }

    void testUpdateEntrance(ParkRepository repo, Park p)   {
        repo.updateEntrance(p);
    }

    void testUpdateExit(ParkRepository repo, Park p)   {
        repo.updateExit(p);
    }
}

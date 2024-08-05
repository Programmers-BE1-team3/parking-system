import domain.Car;
import domain.CarType;
import domain.Member;
import domain.Rank;
import services.CarService;
import services.MemberService;
import services.ParkService;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {

        MemberService memberService = new MemberServiceImpl(memRepo);
        CarService carService = new CarServiceImpl(carRepo);
        ParkService parkService = new ParkServiceImpl(parkRepo);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("1:회원가입 2:차량등록 3:입차하기 4:출차하기 -1:종료");
            int select = Integer.parseInt(br.readLine());
            if (select == -1) break;

            switch (select) {
                case 1:
                    System.out.print("이름을 입력하세요>> ");
                    String user_name = br.readLine();
                    System.out.print("전화번호를 입력하세요>> ");
                    String phone_num = br.readLine();
                    System.out.print("이 건물의 거주자이십니까? 1:네 2:아니요 ");
                    int n = Integer.parseInt(br.readLine());
                    Rank rank = (n == 1) ? Rank.FAMILY : Rank.GOLD;
                    memberService.register(new Member(user_name, phone_num, rank));
                    System.out.println("회원등록을 완료하였습니다.");
                    break;

                case 2:
                    System.out.println("----차량 등록----");
                    System.out.print("차량 번호를 입력해주세요>> ");
                    String car_num = br.readLine();
                    CarType car_type = null;
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.print("차량 타입을 선택하세요>> ");
                        System.out.println("1:소 2:중 3:대 ");
                        int type = Integer.parseInt(br.readLine());
                        switch (type) {
                            case 1:
                                car_type = CarType.SMALL;
                                validInput = true;
                                break;
                            case 2:
                                car_type = CarType.MEDIUM;
                                validInput = true;
                                break;
                            case 3:
                                car_type = CarType.LARGE;
                                validInput = true;
                                break;
                            default:
                                System.out.println("잘못된 입력입니다. 1, 2, 3 중 하나를 선택하세요.");
                                break;
                        }
                    }
                    carService.register(new Car(car_num, car_type));
                    System.out.println("차량 등록을 완료하였습니다.");
                    break;

                case 3:
                    System.out.println("----입차하기----");
                    parkService.showParkingInfo();
                    System.out.print("이용 원하시는 주차 자리를 입력해주세요>> ");
                    int parking_slot_id = Integer.parseInt(br.readLine());

                    System.out.print("차량 번호를 입력해주세요>> ");
                    car_num = br.readLine();
                    Car car = carService.findCar(car_num);
                    if (car == null) {
                        System.out.println("등록되지 않은 차량입니다. 차량을 먼저 등록해주세요.");
                        break;
                    }

                    boolean parked = parkService.enterParking(car, parking_slot_id);
                    if (parked) {
                        System.out.println("입차가 완료되었습니다.");
                    } else {
                        System.out.println("입차 실패: 주차 공간이 부족하거나 다른 문제가 발생했습니다.");
                    }
                    break;

                case 4:
                    System.out.println("----출차하기----");
                    System.out.print("차량 번호를 입력해주세요>> ");
                    car_num = br.readLine();

                    System.out.print("주차 칸 ID를 입력해주세요>> ");
                    int slot_id = Integer.parseInt(br.readLine());

                    boolean exited = parkService.exitParking(car_num, slot_id);
                    if (exited) {
                        System.out.println("출차가 완료되었습니다.");
                    } else {
                        System.out.println("출차 실패: 차량 번호나 주차 칸 ID가 잘못되었습니다.");
                    }
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                    break;
            }
        }
    }
}
package controller;

<<<<<<< HEAD
import util.*;
=======
import util.ScannerBuffer;
import util.View;
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
import view.LoginService;

public class HostController {
	private HostController() {}
	private static HostController instance;
	public static HostController getInstance(){
		if(instance == null){
			instance = new HostController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance(); 
<<<<<<< HEAD
	
	public void hostMenu() {
		System.out.println(" ────────────────────────────────────────────────────────");
		System.out.println(" \t\t   Host로 입장하였습니다. \t\t\t");
		System.out.println(" ────────────────────────────────────────────────────────");
		while(true) {
			System.out.println("\n 1.방 | 2.렌트카 | 3.관광명소 | 4.마이페이지 | 5.로그아웃\n"); 
			System.out.print(" ✔ 번호를 입력해 주세요 › ");
			int input = scanner.nextInt();
			switch (input) {
				case 1: RoomController.getInstance().roomInformation(); break;
				case 2: CarController.getInstance().carInformation(); break;
				case 3: TourController.getInstance().tourInformation(); break;
				case 4: MypageController.getInstance().mypage(); break;
				case 5: LoginService.loginId= null; return;
				default: System.out.println("\n [ 잘못 입력하였습니다 ]\n");
=======
	private RoomController roomController = RoomController.getInstance();
	private CarController carController = CarController.getInstance();
	private TourController tourController = TourController.getInstance();
	private MypageController mypage = MypageController.getInstance();
	
	public void hostMenu() {
		System.out.println("== Host로 입장하였습니다. ==");
		while(true) {
			System.out.println("1.방 2.렌트카 3.관광명소 4.마이페이지 5.로그아웃"); 
			System.out.print("번호를 입력해주세요> ");
			int input = scanner.nextInt();
			switch (input) {
				case 1: roomController.roomInformation(); break;
				case 2: carController.carInformation(); break;
				case 3: tourController.tourInformation(); break;
				case 4: mypage.mypage(); break;
				case 5: LoginService.loginId= null; return;
				default: System.out.println("잘못 입력하였습니다.");
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
			}
		}
	}
}
package controller;

<<<<<<< HEAD
import util.*;
=======
import util.ScannerBuffer;
import util.View;
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
import view.*;

public class CustomerController {
	private CustomerController() {
	}

	private static CustomerController instance;

	public static CustomerController getInstance() {
		if (instance == null) {
			instance = new CustomerController();
		}
		return instance;
	}

	private ScannerBuffer scanner = ScannerBuffer.getInstance();
<<<<<<< HEAD
	
	public void customerMenu() {
		System.out.println(" ─────────────────────────────────────────────");
		System.out.println(" \t   Customer로 입장하였습니다. \t\t\t");
		System.out.println(" ─────────────────────────────────────────────");
		while (true) {
			System.out.println("\n\n 1.패키지 | 2.결제 | 3.마이페이지 | 4.로그아웃\n");
			System.out.print(" ✔ 번호를 입력해 주세요 › ");
			int input = scanner.nextInt();
			switch (input) {
				case 1: CustomerRegister.getinstance().packMenu(); break;
				case 2: Payment.getInstance().paymentHistory(); break;
				case 3: MypageController.getInstance().mypage(); break;
				case 4: LoginService.loginId = null; return;
				default: System.out.println("\n [ 잘못 입력하였습니다 ]\n");
			}
		}
	}
}
=======
	private MypageController mypage = MypageController.getInstance();
	private CustomerRegister customerRegister = CustomerRegister.getinstance();
	
	public void customerMenu() {
		System.out.println("== Customer로 입장하였습니다. ==");
		while (true) {
			System.out.println("1.패키지 2.결제 3.마이페이지 4.로그아웃");
			System.out.print("번호를 입력해주세요> ");
			int input = scanner.nextInt();
			switch (input) {
				case 1: customerRegister.packManu(); break;
				case 2: customerRegister.customerChoice(); break;
				case 3: mypage.mypage(); break;
				case 4: LoginService.loginId = null; return;
				default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}



}
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9

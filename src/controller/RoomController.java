package controller;

<<<<<<< HEAD
import util.*;
=======
import util.ScannerBuffer;
import util.View;
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
import view.RoomRegister;

public class RoomController {
	private RoomController() {}
	private static RoomController instance;
	public static RoomController getInstance(){
		if(instance == null){
			instance = new RoomController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private RoomRegister roomRegister = RoomRegister.getInstance();
	
	public void roomInformation() {
<<<<<<< HEAD
		while(true) {
			System.out.println("\n\n 1.방 등록 | 2.방 삭제 | 3.목록 조회 | 4.뒤로가기\n");
			System.out.print(" ✔ 번호를 입력해 주세요 › ");
=======
		while (true) {
			System.out.println("1.방 등록 2.방 삭제 3.목록 조회 4.뒤로가기");
			System.out.print("번호를 입력해주세요> ");
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
			int input = scanner.nextInt();
			switch (input) {
				case 1: roomRegister.roomInsert(); break;
				case 2: roomRegister.roomDelete(); break;
				case 3: roomRegister.roomSearch(); break;
				case 4: return;
<<<<<<< HEAD
				default: System.out.println("\n [ 잘못 입력하였습니다 ]\n");
			}
		}
	}
}
=======
				default: System.out.println("잘못 입력하였습니다.");
			}
		}
	}
}
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9

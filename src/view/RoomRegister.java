package view;

import java.util.ArrayList;
import java.util.HashMap;

import dao.RoomDAO;
import util.ScannerBuffer;
import vo.RoomVO;

public class RoomRegister {
	private RoomRegister() {}
	private static RoomRegister instance;
	public static RoomRegister getInstance() {
		if (instance == null) {
			instance = new RoomRegister();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance(); 
	private RoomDAO roomDao = RoomDAO.getInstance();

	public void roomInsert() {
		System.out.print("방 이름> ");
		String roomName = scanner.next();
		System.out.print("수용인원> ");
		int maxCapacity = scanner.nextInt();
		System.out.print("방 개수> ");
		int roomCount = scanner.nextInt();
		System.out.print("침대 개수> ");
		int bedCount = scanner.nextInt();
		System.out.print("가격> ");
		int roomPrice = scanner.nextInt();
		System.out.print("지역> ");
		String city = scanner.next();
		System.out.print("설명> ");
		String explanation = scanner.next();
		if (roomDao.insertRoom(new RoomVO(LoginService.loginId.getUserId(), roomName, maxCapacity, roomCount, bedCount, roomPrice, city, explanation)) == 0) {
			System.out.println("등록에 실패했습니다.\n\n\n");
		} else {
			System.out.println("등록 성공\n\n\n");
		}
	}
	
	public void roomDelete() {
		System.out.print("방 번호> ");
		int roomNumber = scanner.nextInt();
		if (roomDao.deleteRoom(new RoomVO(roomNumber)) == 1) {
			System.out.println("삭제되었습니다.\n\n\n");
		} else {
			System.out.println("존재하지 않거나 본인이 등록한 방이 아닙니다.\n\n\n");
		}
	}
	
	public void roomSearch() {
		ArrayList<HashMap<String, Object>> list = roomDao.select(LoginService.loginId);
		int size = list.size();
		System.out.println("번호\t\t이름\t\t수용인원\t방 개수\t침대 개수\t가격\t지역\t설명");
		for(int i=0; i<size;i++) {
			System.out.print(list.get(i).get("ROOM_NUMBER")+"\t");
			System.out.printf("%16s\t",list.get(i).get("ROOM_NAME"));
			System.out.print(list.get(i).get("MAX_CAPACITY")+"\t");
			System.out.print(list.get(i).get("ROOM_COUNT")+"\t");
			System.out.print(list.get(i).get("BED_COUNT")+"\t");
			System.out.print(list.get(i).get("ROOM_PRICE")+"\t");
			System.out.print(list.get(i).get("CITY")+"\t");
			System.out.print(list.get(i).get("EXPLANATION")+"\n");
		}
		System.out.println("\n\n\n");
	}
}

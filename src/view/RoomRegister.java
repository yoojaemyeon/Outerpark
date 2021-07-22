package view;

<<<<<<< HEAD
import java.text.DecimalFormat;
=======
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
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
<<<<<<< HEAD
	private DecimalFormat formatter = new DecimalFormat("###,###");

	public void roomInsert() {
		System.out.print("\n\n ✔ 방 이름 › ");
		String roomName = scanner.next();
		System.out.print("\n ✔ 수용인원 › ");
		int maxCapacity = scanner.nextInt();
		System.out.print("\n ✔ 방 개수 › ");
		int roomCount = scanner.nextInt();
		System.out.print("\n ✔ 침대 개수 › ");
		int bedCount = scanner.nextInt();
		System.out.print("\n ✔ 가격 › ");
		int roomPrice = scanner.nextInt();
		System.out.print("\n ✔ 지역 › ");
		String city = scanner.next();
		System.out.print("\n ✔ 설명 › ");
		String explanation = scanner.next();
		if (roomDao.insertRoom(new RoomVO(LoginService.loginId.getUserId(), roomName, maxCapacity, roomCount, bedCount, roomPrice, city, explanation)) == 0) {
			System.out.println("\n [ 등록 실패 ]\n");
		} else {
			System.out.println("\n ◈◈ 등록 성공 ◈◈ \n");
=======

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
			System.out.println("등록에 실패했습니다.");
		} else {
			System.out.println("등록 성공");
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}
	}
	
	public void roomDelete() {
<<<<<<< HEAD
		System.out.print("\n ✔ 삭제할 방 번호 › ");
		int roomNumber = scanner.nextInt();
		if (roomDao.deleteRoom(new RoomVO(roomNumber)) == 1) {
			System.out.println("\n ◈◈ 삭제되었습니다 ◈◈\n");
		} else {
			System.out.println("\n [ 존재하지 않거나 본인이 등록한 방이 아닙니다 ]\n");
=======
		System.out.print("방 번호> ");
		int roomNumber = scanner.nextInt();
		if (roomDao.deleteRoom(new RoomVO(roomNumber)) == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("존재하지 않거나 본인이 등록한 방이 아닙니다.");
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}
	}
	
	public void roomSearch() {
		ArrayList<HashMap<String, Object>> list = roomDao.select(LoginService.loginId);
		int size = list.size();
<<<<<<< HEAD
		System.out.println("\n\n   < 번호 >\t  < 이름 >\t     < 최대인원 >    < 방 개수 >\t< 침대 개수 >    < 가격 >   < 지역 >     < 설명 >\n");
		for(int i=0; i<size;i++) {
			System.out.printf("     %s",list.get(i).get("ROOM_NUMBER")+"\t\t ");
			System.out.print(list.get(i).get("ROOM_NAME")+"\t\t ");
			System.out.print(list.get(i).get("MAX_CAPACITY")+"\t       ");
			System.out.print(list.get(i).get("ROOM_COUNT")+"\t     ");
			System.out.print(list.get(i).get("BED_COUNT")+"\t      ");
			System.out.print(formatter.format(list.get(i).get("ROOM_PRICE"))+"\t  ");
			System.out.print(list.get(i).get("CITY")+"\t    ");
			System.out.print(list.get(i).get("EXPLANATION")+"\n\n");
=======
		String[] key = {"ROOM_NUMBER","ROOM_NAME","MAX_CAPACITY","ROOM_COUNT","BED_COUNT","ROOM_PRICE","CITY","EXPLANATION"};
		System.out.println("번호\t이름\t수용인원\t방 개수\t침대 개수\t가격\t지역\t설명");
		for(int i=0; i<size;i++) {
			for(int j=0; j<key.length; j++) {
				System.out.print(list.get(i).get(key[j])+"\t");
			}
			System.out.println();
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}
	}
}
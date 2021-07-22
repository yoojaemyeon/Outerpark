package view;

<<<<<<< HEAD
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import dao.*;
import vo.*;
import util.*;
=======
import java.util.ArrayList;
import java.util.HashMap;

import dao.*;
import util.ScannerBuffer;
import vo.*;
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9

public class CustomerRegister {
	
	private CustomerRegister() {}
	private static CustomerRegister instance;
	public static CustomerRegister getinstance() {
	if (instance == null) {
		instance = new CustomerRegister();
	}	
		return instance;
	}
		
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
<<<<<<< HEAD
	private DecimalFormat formatter = new DecimalFormat("###,###");
	
	public void packMenu() {
		System.out.println("\n\n -----------------------------------------------------------");
		System.out.println(" \t\t\t   PACKAGE \t\t\t");
		System.out.println(" -----------------------------------------------------------");
		
		String wantCity = "";
		
		while(wantCity.isEmpty()) {
			System.out.println("\n 1.서울 | 2.대전 | 3.목포 | 4.인천 | 5.광주 | 6.울산 | 7.부산");
			System.out.print("\n ✔ 원하는 지역의 번호를 입력해 주세요 › ");
=======
	private String wantCity = "";
	private int maxPeople;
	private String carNumber;
	private int roomNumber;
	private int tourNumber;
	private String startDate;
	private String endDate;
	private int cnt;
	
	public void packManu() {
		System.out.println("== PACKAGE ==");
		
		while(wantCity.isEmpty()) {
			System.out.println("1.서울|2.대전|3.목포|4.인천|5.광주|6.울산|7.부산");// 안적어도 넘어감
			System.out.print("* 원하는 지역의 번호를 입력하세요: ");
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
			int wantCityInt = scanner.nextInt();
			switch (wantCityInt) {
				case 1: wantCity = "서울"; break;
				case 2: wantCity = "대전"; break;
				case 3: wantCity = "목포"; break;
				case 4: wantCity = "인천"; break;
				case 5: wantCity = "광주"; break;
				case 6: wantCity = "울산"; break;
				case 7: wantCity = "부산"; break;
<<<<<<< HEAD
				default: System.out.println("\n [ 잘못 입력하였습니다 ]\n"); break;
			}
		}
		
		System.out.print("\n ✔ 이용 인원 › ");
	      int maxPeople = scanner.nextInt();
	      Date now = new Date();
	      SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
	      int dateNow = Integer.parseInt(date.format(now));
	      
	      int startDate = 0;
	      while(startDate<dateNow || startDate>21000000 ) {
	         System.out.print("\n ✔ 이용 시작일 (ex.20210721) › ");
	         startDate = scanner.nextInt();
		}
		int endDate =0;
		while(endDate <= startDate) {
			System.out.print("\n ✔ 이용 종료일 (ex.20210722) › ");
			endDate = scanner.nextInt();		
		}
		System.out.println("\n\n ========= 선택 정보 확인  =========\n");
		System.out.println(" * 입력한 지역: " + wantCity);
		System.out.println("\n * 입력한 인원: " + maxPeople);
		System.out.println("\n * 입력한 날짜: " + startDate + " ~ " + endDate);
		System.out.println("\n ===================================\n");
		int input=0;
		while(input!=1) {
			System.out.print(" ✔ 선택하신 정보가 맞다면 1 아니면 0을 입력해 주세요 › ");
			input = scanner.nextInt();			
			switch(input) {
			case 0 : return;
			case 1 : break;
			default : break;
			}
		}
		customerChoice(wantCity, startDate, endDate, maxPeople);
		
	}
	

	public void customerChoice(String wantCity,int startDate, int endDate, int maxPeople) {
		double saleRate;
		System.out.println("\n\n\n =========================================== 등록된 차량 목록 ===========================================");
		String carNumber = carChoice(wantCity,maxPeople);
		System.out.println("\n\n\n =========================================================================================== 등록된 방 목록 ===========================================================================================");
	    int roomNumber = roomChoice(wantCity,maxPeople);
	    System.out.println("\n\n\n ================================================== 등록된 투어 목록 ==================================================");
		int tourNumber = tourChoice(wantCity,maxPeople);
		int cnt = 0;
		if(carNumber.equals("0")) cnt++;
		if(roomNumber==0) cnt++;
		if(tourNumber==0) cnt++;
		switch (cnt) {
		case 0: saleRate = 0.8; break;
		case 1: saleRate = 0.9; break;
		case 2: saleRate = 1; break;
		case 3: System.out.println("\n [ 입력된 정보가 없습니다 ]\n"); return;
		default: System.out.println("\n ※※ 에러 ※※\n"); return;
		}

		 if(PackDAO.getInstance().insertPack(new PackVO(tourNumber,roomNumber,carNumber,startDate,endDate,maxPeople))==1) {
	         int packNumber = PackDAO.getInstance().getPackNumber();
	         int carPrice = CarDAO.getInstance().selectCarPrice(carNumber);
	         int roomPrice = RoomDAO.getInstance().selectRoomPrice(roomNumber);
	         int tourPrice = TourDAO.getInstance().selectTourPrice(tourNumber);
	         int price = Datecalculate.getinstance().dateDifference(startDate+"",endDate+"")*(int)((carPrice+roomPrice+tourPrice*maxPeople)*saleRate);
	         
	         PaymentDAO.getInstance().insertPayment(LoginService.loginId.getUserId(), packNumber,price);
			System.out.println("\n ◈◈ 정상등록 되었습니다 ◈◈ \n");
		}else {
			System.out.println("\n [ 등록에 실패하였습니다 ]\n");
		}
	}
	
	public String carChoice(String wantCity, int maxPeople) {
	      ArrayList<HashMap<String, Object>> list = CarDAO.getInstance().selectCar(new CarVO(wantCity,maxPeople));
	      int size = list.size();
	      System.out.println("\n < 번호 >\t\t < 차 번호 >\t< 종류 >\t\t< 가격 >\t\t< 인승 >\t\t< 지역 >\t\t< 색상 >\n");
	      for(int i=0; i<size;i++) {
	         System.out.print("    " + (i + 1) + "\t\t ");
	         System.out.print(list.get(i).get("CAR_NUMBER")+"\t");
	         System.out.print(list.get(i).get("CAR_KIND")+"\t");
	         System.out.print(formatter.format(list.get(i).get("CAR_PRICE"))+"\t\t   ");
	         System.out.print(list.get(i).get("CAR_SEATS")+"\t\t   ");
	         System.out.print(list.get(i).get("CITY")+"\t\t  ");
	         System.out.print(list.get(i).get("CAR_COLOR")+"\n\n");
	      }
	      System.out.println("=========================================================================================================");
	      System.out.print("\n ✔ 원하는 차량의 번호를 입력해 주세요 (미선택시 0을 입력해주세요) › ");
	      int input = scanner.nextInt();
	      String carNumber = "0";
	      if(input != 0) carNumber = list.get(input-1).get("CAR_NUMBER")+"";
	      return carNumber;
	}
	
	public int roomChoice(String wantCity, int maxPeople) {
		ArrayList<HashMap<String, Object>> list = RoomDAO.getInstance().selectRoom(new RoomVO(wantCity,maxPeople));
		int size = list.size();
		System.out.println("\n < 번호 >\t\t   < 이름 >\t    < 최대인원 >    < 방 개수 > < 침대 개수 >\t  < 가격 >\t < 지역 >    < 설명 >\n");
		for(int i=0; i<size;i++) {
			System.out.print("    " + (i + 1) + "\t\t ");
			System.out.print(list.get(i).get("ROOM_NAME")+"\t\t");
			System.out.print(list.get(i).get("MAX_CAPACITY")+"\t      ");
			System.out.print(list.get(i).get("ROOM_COUNT")+"\t\t");
			System.out.print(list.get(i).get("BED_COUNT")+"\t  ");
			System.out.print(formatter.format(list.get(i).get("ROOM_PRICE"))+"\t   ");
			System.out.print(list.get(i).get("CITY")+"\t    ");
			System.out.print(list.get(i).get("EXPLANATION")+"\n\n");
		}
		System.out.println("=======================================================================================================================================================================================================");
		System.out.print("\n ✔ 원하는 방의 번호를 입력해 주세요 (미선택시 0을 입력해주세요) › ");
		int input= scanner.nextInt();
		int roomNumber = 0;
		if(input != 0) roomNumber = Integer.parseInt(list.get(input-1).get("ROOM_NUMBER")+"");
		return roomNumber;
	}
	
	public int tourChoice(String wantCity, int maxPeople) {
		ArrayList<HashMap<String, Object>> list = TourDAO.getInstance().selectTour(new TourVO(wantCity));
		int size = list.size();
		System.out.println("\n < 번호 >\t      < 이름 >\t  < 시간 >   < 가격 >     < 지역 >\t< 설명 >\n");
		for(int i=0; i<size;i++) {
			System.out.print("    " + (i + 1) + "\t     ");
			System.out.print(list.get(i).get("TOUR_NAME")+"\t    ");
			System.out.print(list.get(i).get("TOUR_TIME")+"\t    ");
			System.out.print(formatter.format(list.get(i).get("TOUR_PRICE"))+"\t ");
			System.out.print(list.get(i).get("CITY")+"       ");
			System.out.print(list.get(i).get("EXPLANATION")+"\n\n");
		}
		System.out.println("========================================================================================================================");
		System.out.print("\n ✔ 원하는 투어의 번호를 입력해 주세요 (미선택시 0을 입력해주세요) › ");
		int input = scanner.nextInt();
		int tourNumber = 0;
		if(input != 0) tourNumber = Integer.parseInt(list.get(input-1).get("TOUR_NUMBER")+"");
		return tourNumber;
	}
=======
				default: System.out.println("잘못 입력하였습니다."); break;
			}
		}
		
		System.out.print("* 이용 인원: ");
		maxPeople = scanner.nextInt();
		System.out.println("* 이용 시작일: (ex.20210719)");
		startDate = scanner.next();
		System.out.println("* 이용 종료일: (ex.20210719)");
		endDate = scanner.next();
		System.out.println("== 확인창 ==");
		System.out.println("* 입력한 지역: " + wantCity);
		System.out.println("* 입력한 인원: " + maxPeople);
		System.out.println("* 입력한 날짜: " + startDate + " ~ " + endDate);
		customerChoice();
	}
	

	public void customerChoice() {// 차,방,투어 선택
		double saleRate;
		switch (cnt) {
			case 0: saleRate = 0.8; break;
			case 1: saleRate = 0.9; break;
			case 2: saleRate = 1; break;
			case 3: System.out.println("입력된 정보가 없습니다."); return;
			default: System.out.println("에러"); return;
		}
		System.out.println("** 등록된 차량 목록 **");
		carChoice();
		System.out.println("** 등록된 방 목록 **");
	    roomChoice();
	    System.out.println("** 등록된 투어 목록 **");
		tourChoice();
		if(PackDAO.getInstance().insertPack(new PackVO(tourNumber,roomNumber,carNumber,startDate,endDate,maxPeople))==1) {
			int packNumber = PackDAO.getInstance().getPackNumber();
			int carPrice = CarDAO.getInstance().selectCarPrice(carNumber);
			int roomPrice = RoomDAO.getInstance().selectRoomPrice(roomNumber);
			int tourPrice = TourDAO.getInstance().selectTourPrice(tourNumber);
			int price = (Integer.parseInt(endDate)-Integer.parseInt(startDate))*(int)((carPrice+roomPrice+tourPrice)*saleRate);
			
			PaymentDAO.getInstance().insertPayment(LoginService.loginId.getUserId(), packNumber,price);
			System.out.println("정상등록 되었습니다.");
		}else {
			System.out.println("등록 실패하였습니다.");
		}
		

	}
	
	public void carChoice() {
		ArrayList<HashMap<String, Object>> list = CarDAO.getInstance().selectCar(new CarVO(wantCity,maxPeople));
		int size = list.size();
		String[] key = { "CAR_NUMBER", "CAR_KIND", "CAR_PRICE", "CAR_SEATS", "CITY", "CAR_COLOR" };
		System.out.println("번호\t종류\t가격\t인승\t지역\t색상");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(list.get(i).get(key[j]) + "\t");
			}
			System.out.println();
			
		}
		System.out.println("* 원하는 차량의 번호를 입력해주세요: (미선택시 0을 입력해주세요)");
		carNumber = scanner.next();
		if(carNumber.equals("0")) cnt++;
		
	}
	
	public void roomChoice() {
		ArrayList<HashMap<String, Object>> list = RoomDAO.getInstance().selectRoom(new RoomVO(wantCity,maxPeople));
		int size = list.size();
		String[] key = { "ROOM_NUMBER","ROOM_NAME","ROOM_COUNT", "BED_COUNT","ROOM_PRICE","CITY", "EXPLANATION" };
		System.out.println("방번호\t숙소이름\t방갯수\t침대갯수\t숙소가격\t지역\t숙소설명");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(list.get(i).get(key[j]) + "\t");
			}
			System.out.println();
		}
		System.out.println("* 원하는 방의 번호을 입력해주세요: (미선택시 0을 입력해주세요)");
		roomNumber= scanner.nextInt();
		if(roomNumber==0) cnt++;
		
	}
	
	public void tourChoice() {
		ArrayList<HashMap<String, Object>> list = TourDAO.getInstance().selectTour(new TourVO(wantCity));
		int size = list.size();
		String[] key = { "TOUR_NUMBER","TOUR_NAME", "TOUR_TIME", "TOUR_PRICE", "CITY", "EXPLANATION" };
		System.out.println("투어번호\t투어이름\t투어시간\t투어가격\t지역\t투어설명");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(list.get(i).get(key[j]) + "\t");
			}
			System.out.println();
		}
		System.out.println("* 원하는 투어의 번호을 입력해주세요: (미선택시 0을 입력해주세요)");
		tourNumber = scanner.nextInt();
		if(tourNumber==0) cnt++;
	}
	
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
}
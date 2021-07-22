package view;

<<<<<<< HEAD
import java.text.DecimalFormat;
=======
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
import java.util.ArrayList;
import java.util.HashMap;

import dao.CarDAO;
import util.ScannerBuffer;
import vo.CarVO;

public class CarRegister {
	private CarRegister() {}
	private static CarRegister instance;
	public static CarRegister getInstance(){
		if(instance == null){
			instance = new CarRegister();
		}
		return instance;
	}
	
	private CarDAO carDao = CarDAO.getInstance();
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
<<<<<<< HEAD
	private DecimalFormat formatter = new DecimalFormat("###,###");
	
	public void carInsert() {
		System.out.print("\n\n ✔ 차 번호 › ");
		String carNumber = scanner.next();
		System.out.print("\n ✔ 차 종류 › ");
		String carKind = scanner.next();
		System.out.print("\n ✔ 가격 › ");
		int carPrice = scanner.nextInt();
		System.out.print("\n ✔ 인승 › ");
		int carSeats = scanner.nextInt();
		System.out.print("\n ✔ 지역 › ");
		String city = scanner.next();
		System.out.print("\n ✔ 차 색상 › ");
		String carColor = scanner.next();
		if (carDao.insertCar(new CarVO(carNumber, LoginService.loginId.getUserId(), carKind, carPrice, carSeats, city, carColor)) == 1) {
			System.out.println("\n ◈◈ 등록 성공 ◈◈ \n");
		} else {
			System.out.println("\n [ 등록 실패 ]\n");
=======
	
	public void carInsert() {
		System.out.print("차 번호> ");
		String carNumber = scanner.next();
		System.out.print("차 종류> ");
		String carKind = scanner.next();
		System.out.print("가격> ");
		int carPrice = scanner.nextInt();
		System.out.print("인승> ");
		int carSeats = scanner.nextInt();
		System.out.print("지역> ");
		String city = scanner.next();
		System.out.print("차 색상> ");
		String carColor = scanner.next();
		if (carDao.insertCar(new CarVO(carNumber, LoginService.loginId.getUserId(), carKind, carPrice, carSeats, city, carColor)) == 1) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록에 실패했습니다.");
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}
	}
	
	public void carDelete() {
<<<<<<< HEAD
		System.out.print("\n ✔ 차 번호 › ");
		String carNumber = scanner.next(); 
		if (carDao.deleteCar(new CarVO(carNumber)) == 1) {
			System.out.println("\n ◈◈ 삭제되었습니다 ◈◈\n");
		} else {
			System.out.println("\n [ 존재하지 않거나 본인이 등록한 차가 아닙니다 ]\n");
=======
		System.out.print("차 번호> ");
		String carNumber = scanner.next(); 
		if (carDao.deleteCar(new CarVO(carNumber)) == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("존재하지 않거나 본인이 등록한 차가 아닙니다.");
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}
	}
	
	public void carSearch() {
		ArrayList<HashMap<String, Object>> list = carDao.select(LoginService.loginId);
		int size = list.size();
<<<<<<< HEAD
		System.out.println("\n\n  < 번호 >\t< 종류 >\t\t< 가격 >\t\t< 인승 >\t\t< 지역 >\t\t< 색상 >\n");
		for(int i=0; i<size;i++) {
			System.out.printf(" %s",list.get(i).get("CAR_NUMBER")+"\t");
			System.out.printf("%s\t",list.get(i).get("CAR_KIND"));
			System.out.print(formatter.format(list.get(i).get("CAR_PRICE"))+"\t\t   ");
			System.out.print(list.get(i).get("CAR_SEATS")+"\t\t  ");
			System.out.print(list.get(i).get("CITY")+"\t\t ");
			System.out.print(list.get(i).get("CAR_COLOR")+"\n\n");
=======
		String[] key = {"CAR_NUMBER","CAR_KIND","CAR_PRICE","CAR_SEATS","CITY","CAR_COLOR"};
		System.out.println("번호\t종류\t가격\t인승\t지역\t색상");
		for(int i=0; i<size;i++) {
			for(int j=0; j<key.length; j++) {
				System.out.print(list.get(i).get(key[j])+"\t");
			}
			System.out.println();
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
		}
	}
}
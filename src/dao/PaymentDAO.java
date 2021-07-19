package dao;

import util.JDBCUtil;
import vo.PackVO;
import vo.PaymentVO;

public class PaymentDAO {
	private static PaymentDAO instance = new PaymentDAO(); 
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	
	
	private PaymentDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertPayment(String userId, int packNumber,int price) {
		String query = String.format("INSERT INTO PAYMENT VALUES(SEQ_PAYMENT.NEXTVAL,'%s',%d,SYSDATE,'결제대기',%d)"
				,userId,packNumber,price);
		return jdbc.Update(query);
	}
	
	
	
}
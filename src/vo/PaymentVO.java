package vo;

public class PaymentVO {
<<<<<<< HEAD
	private int cartNumber;
	private String userId;
	private int packNumber;
	private String payDate;
	private String refund;
	
	public PaymentVO(int cartNumber, String userId, int packNum, String payDate, String refund) {
		super();
		this.cartNumber = cartNumber;
		this.userId = userId;
		this.packNumber = packNum;
		this.payDate = payDate;
		this.refund = refund;
	}
	
	public PaymentVO(String userId, int packNum, String payDate, String refund) {
		super();
		this.userId = userId;
		this.packNumber = packNum;
		this.payDate = payDate;
		this.refund = refund;
	}
	
	public int getCartNo() {
		return cartNumber;
	}
	public void setCartNo(int cartNo) {
		this.cartNumber = cartNo;
=======
	private int cartNo;
	private String userId;
	private int packNum;
	private String payDate;
	private String refund;
	private int price;
	
	public PaymentVO(String userId, int packNum, String payDate, String refund,int price) {
		super();
		this.userId = userId;
		this.packNum = packNum;
		this.payDate = payDate;
		this.refund = refund;
		this.price = price;
	}
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPackNum() {
<<<<<<< HEAD
		return packNumber;
	}
	public void setPackNum(int packNum) {
		this.packNumber = packNum;
=======
		return packNum;
	}
	public void setPackNum(int packNum) {
		this.packNum = packNum;
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return "PaymentVO [cartNumber=" + cartNumber + ", userId=" + userId + ", packNumber=" + packNumber + ", payDate=" + payDate
				+ ", refund=" + refund + "]";
	}
}
=======
		return "PaymentVO [cartNo=" + cartNo + ", userId=" + userId + ", packNum=" + packNum + ", payDate=" + payDate
				+ ", refund=" + refund + "]";
	}
}
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9

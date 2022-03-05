package chap08.after.pay.model;

public class PayInfo {
	String payId;
	String data_1;
	Integer data_2;
	
	public PayInfo(String payId, String data_1, Integer data_2) {
		this.payId = payId;
		this.data_1 = data_1;
		this.data_2 = data_2;
	}
	
	public String getPayId() {
		return payId;
	}

}

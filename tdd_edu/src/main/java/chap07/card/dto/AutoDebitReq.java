package chap07.card.dto;

public class AutoDebitReq {
	String userId;
	String cardNumber;
	public AutoDebitReq(String userId, String cardNumber) {
		this.userId = userId;
		this.cardNumber = cardNumber;
	}
	public String getUserId() {
		return userId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
}

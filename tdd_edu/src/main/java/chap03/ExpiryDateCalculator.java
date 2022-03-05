package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
	
	//서비스를 사용하려면 매달 1만 원을 선불로 납부한다. 납부일 기준으로 한달 뒤 서비스 만료일이 된다.
	public LocalDate calculateExpiryDate(PayData payData) {
		int addedMonths = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;
		if(payData.getFirstBillingDate() != null) {
			return expiryDateUsingFirstbillingDate(payData, addedMonths);
		}else {
			return payData.getBillingDate().plusMonths(addedMonths);
		}
	}

	private LocalDate expiryDateUsingFirstbillingDate(PayData payData, int addedMonths) {
		LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
		final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
		if(isSameDayOfMonth(dayOfFirstBilling,candidateExp)) {
			final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
			if(dayLenOfCandiMon < dayOfFirstBilling) {
				return candidateExp.withDayOfMonth(dayLenOfCandiMon);
			}
			
			return candidateExp.withDayOfMonth(dayOfFirstBilling);
		}
		/*
		 * if(payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))) { return
		 * LocalDate.of(2019, 3, 31); }
		 */
		
		return candidateExp;
	}
	
	private boolean isSameDayOfMonth(int dayOfFirstBilling, LocalDate candidateExp) {
		if(dayOfFirstBilling != candidateExp.getDayOfMonth()) {
			return true;
		}
		
		return false;
	}
	
	private int lastDayOfMonth(LocalDate date) {
		return YearMonth.from(date).lengthOfMonth();
	}
}

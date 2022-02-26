package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {
	//납부한 금액을 기준으로 서비스 만료일을 계산하는 기능
	
	private ExpiryDateCalculator cal = new ExpiryDateCalculator();
	
	private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
		LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
		assertEquals(expectedExpiryDate, realExpiryDate);
		
	}
	
	@Test 
	//서비스를 사용하려면 매달 1만 원을 선불로 납부한다. 납부일 기준으로 한달 뒤 서비스 만료일이 된다.
	void checkExpiryDate() {
		assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 3, 1)).payAmount(10_000).build() , LocalDate.of(2019, 4, 1));
		assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 5, 5)).payAmount(10_000).build() , LocalDate.of(2019, 6, 5));
	}
	
	@Test
	//납부일과 한달뒤 일자가 같지 않음
	void checkExpiryDate_Type1() {
		assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 1, 31)).payAmount(10_000).build() , LocalDate.of(2019, 2, 28));
		assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 5, 31)).payAmount(10_000).build() , LocalDate.of(2019, 6, 30));
		assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2020, 1, 31)).payAmount(10_000).build() , LocalDate.of(2020, 2, 29));
	}
	
	@Test
	//첫 납부일과 만료일 일자가 다를때 만원 납부
	void checkExpiryDate_Type2() {
		PayData payData = PayData.builder()
		.firstBillingDate(LocalDate.of(2019, 1, 31))
		.billingDate(LocalDate.of(2019, 2, 28))
		.payAmount(10_000)
		.build();
		
		assertExpiryDate(payData , LocalDate.of(2019, 3, 31));
		
		
		PayData payData2 = PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 1, 30))
				.billingDate(LocalDate.of(2019, 2, 28))
				.payAmount(10_000)
				.build();
				
		assertExpiryDate(payData2 , LocalDate.of(2019, 3, 30));
		
		
		PayData payData3 = PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 5, 31))
				.billingDate(LocalDate.of(2019, 6, 30))
				.payAmount(10_000)
				.build();
				
		assertExpiryDate(payData3 , LocalDate.of(2019, 7, 31));
	}
	
	@Test
	void 이만원_이상_납부하면_비례해서_납부일_계산() {
		PayData payData1 = PayData.builder()
				.billingDate(LocalDate.of(2019, 3, 1))
				.payAmount(20_000)
				.build();
				
		assertExpiryDate(payData1 , LocalDate.of(2019, 5, 1));
		
		PayData payData2 = PayData.builder()
				.billingDate(LocalDate.of(2019, 3, 1))
				.payAmount(30_000)
				.build();
				
		assertExpiryDate(payData2 , LocalDate.of(2019, 6, 1));
	}
	
	@Test
	void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
		PayData payData = PayData.builder()
				.firstBillingDate(LocalDate.of(2019, 1, 31))
				.billingDate(LocalDate.of(2019, 2, 28))
				.payAmount(20_000)
				.build();
				
		assertExpiryDate(payData , LocalDate.of(2019, 4, 30));
	}
	
	@Test
	void 십만원을_납부하면_1년_제공() {
		PayData payData = PayData.builder()
				.billingDate(LocalDate.of(2019, 1, 28))
				.payAmount(100_000)
				.build();
				
		assertExpiryDate(payData , LocalDate.of(2020, 1, 28));
	}
}

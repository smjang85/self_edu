package chap08.after.user_point;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import chap08.after.user_point.model.Product;
import chap08.after.user_point.model.Subscription;

public class PointRuleTest {
	@Test
	void 만료전_GOLD등급은_130포인트() {
		PointRule rule = new PointRule();
		Subscription s = new Subscription(
					LocalDate.of(2019, 5, 5),
					Grade.GOLD
				);
		
		Product p = new Product();
		p.setDefaultPoint(20);
		
		int point = rule.calculate(s, p, LocalDate.of(2019, 5, 1));
		
		assertEquals(130, point);
	}
}

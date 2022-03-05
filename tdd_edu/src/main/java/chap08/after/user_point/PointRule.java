package chap08.after.user_point;

import java.time.LocalDate;

import chap08.after.user_point.model.Product;
import chap08.after.user_point.model.Subscription;

public class PointRule {
	public int calculate(Subscription s, Product p, LocalDate now) {
		int point = 0;
		
		if(s.isFinished(now)) {
			point += p.getDefaultPoint();
		} else {
			point += p.getDefaultPoint() + 10;
		}
		
		if(s.getGrade() == Grade.GOLD ) {
			point += 100;
		}
		
		return point;
	}
}

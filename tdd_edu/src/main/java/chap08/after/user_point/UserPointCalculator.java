package chap08.after.user_point;

import java.time.LocalDate;

import chap08.after.user_point.dao.ProductDao;
import chap08.after.user_point.dao.SubscriptionDao;
import chap08.after.user_point.exception.NoSubscriptionException;
import chap08.after.user_point.model.Product;
import chap08.after.user_point.model.Subscription;
import chap08.after.user_point.model.User;

/*
 * 1) 실행 시점에 따라 달라지는 결과
 * - 기능 구현이 섞여 있어 특정한 부분만 테스트하기 어려운 코드
 * 
 * 15행의 LocalDate.now() 에 따라 실행 결과가 달라진다.
 * 
 * Random을 이용해서 임의 값을 사용하는 코드도 비슷하다.
 * 
 * 2) 역할이 섞여 있는 코드
 * 포인트 계산 결과를 테스트하려면 SubscriptionDao와 ProductDao에 대한 대역을 구성해야 한다.
 * 포인트 계산 자체는 이 두 Dao와 상관이 없다. 40~44 행이 필요하다.
 * 하지만 이 두 Dao에 대한 설정이 되야만 테스트가 가능하다.
 * 
 * 3) 그외 테스트가 어려운 코드
 *  -> 메서드 중간에 소켓 통신 코드가 포함되어 있다.
 *  -> 콘솔에서 입력을 받거나 결과를 콘솔에 출력한다.
 *  -> 테스트 대상이 사용하는 의존 대상 클래스나 메서드가 final이다. 이 경우 대역으로 대체가 어려울 수 있다.
 *  -> 테스트 대상의 소스를 소유하고 있지 않아 수정이 여렵다.
 *  
 *    ** 소켓 통신이나 HTTP 통신은 실제를 대체할 서버를 로컬에 띄워서 처리할 수 있다. 서버수준에서 대역을 사용한다고 생각하면 된다.
 */
public class UserPointCalculator {
	private SubscriptionDao subscriptionDao;
	private ProductDao productDao;
	
	public UserPointCalculator(SubscriptionDao subscriptionDao, ProductDao productDao) {
		this.subscriptionDao = subscriptionDao;
		this.productDao = productDao;
	}
	
	//테스트 하고 싶은 코드를 분리하기
	public int calculatePoint(User u) {
		Subscription s = subscriptionDao.selectByUser(u.getId());
		if( s == null ) throw new NoSubscriptionException();
		Product p = productDao.selectById(s.getProductId());
		LocalDate now = LocalDate.now();
		
		int point = new PointRule().calculate(s, p, now);
		
		return point;
	}
	
}

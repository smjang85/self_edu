package design_pattern_edu.strategy_pattern;

import design_pattern_edu.strategy_pattern.animal.Duck;
import design_pattern_edu.strategy_pattern.animal.MallardDuck;
import design_pattern_edu.strategy_pattern.animal.ModelDuck;
import design_pattern_edu.strategy_pattern.behavior.fly.FlyRocketPowered;

/*
 * 1. 전략 패턴
 * 알고리즘군을 정의하고 각각을 캡슐화하여 바꿔 쓸 수 있게 만듭니다.
 * 스트래티지 패턴을 이용하면 알고리즘을 활용하는 클라이언트와 독립적으로 알고리즘을 변경할 수 있습니다.
 * ### 디자인 원칙 ###
 * @ 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분으로부터 분리시킨다.
 * @ 구현이 아닌 인터페이스에 맞춰서 프로그래밍한다.
 * @ 상속 보다는 구성(interface를 활용)
 */
public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}

package design_pattern_edu.strategy_pattern;

import design_pattern_edu.strategy_pattern.animal.Duck;
import design_pattern_edu.strategy_pattern.animal.MallardDuck;
import design_pattern_edu.strategy_pattern.animal.ModelDuck;
import design_pattern_edu.strategy_pattern.behavior.fly.FlyRocketPowered;

/*
 * 1. ���� ����
 * �˰����� �����ϰ� ������ ĸ��ȭ�Ͽ� �ٲ� �� �� �ְ� ����ϴ�.
 * ��Ʈ��Ƽ�� ������ �̿��ϸ� �˰����� Ȱ���ϴ� Ŭ���̾�Ʈ�� ���������� �˰����� ������ �� �ֽ��ϴ�.
 * ### ������ ��Ģ ###
 * @ ���ø����̼ǿ��� �޶����� �κ��� ã�Ƴ���, �޶����� �ʴ� �κ����κ��� �и���Ų��.
 * @ ������ �ƴ� �������̽��� ���缭 ���α׷����Ѵ�.
 * @ ��� ���ٴ� ����(interface�� Ȱ��)
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

package design_pattern_edu.template_method_pattern;

/*
 * 8. 템플릿 메소드 패턴
 * 메소드에서 알고리즘의 골격을 정의합니다.
 * 알고리즘의 여러 단계 중 일부는 서브클래스에서 구현할 수 있습니다. 
 * 템플릿 메소드를 이용하면 알고리즘의 구조는 그대로 유지하면서 서브클래스에서 특정 단계를 재정의할 수 있습니다.
 */
public abstract class CaffeineBeverageWithHook {
	protected void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()) {
			addCondiments();
		}
	}
	
	
	public abstract void brew();
	public abstract void addCondiments();
	
	public void boilWater() {
		System.out.println("물 끓이는 중");
	}
	
	public void pourInCup() {
		System.out.println("컵에 따르는 중");
	}
	
	public boolean customerWantsCondiments() {
		return true;
	}
}

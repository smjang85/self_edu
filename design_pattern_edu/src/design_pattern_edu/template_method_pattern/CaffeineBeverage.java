package design_pattern_edu.template_method_pattern;


public abstract class CaffeineBeverage {
	protected void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	
	public abstract void brew();
	public abstract void addCondiments();
	
	public void boilWater() {
		System.out.println("�� ���̴� ��");
	}
	
	public void pourInCup() {
		System.out.println("�ſ� ������ ��");
	}
	
}

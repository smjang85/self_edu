package design_pattern_edu.template_method_pattern;

public class Coffee extends CaffeineBeverage{

	@Override
	public void brew() {
		System.out.println("���͸� ���ؼ� Ŀ�Ǹ� ������� ��");
	}
	
	@Override
	public void addCondiments() {
		System.out.println("������ ������ �߰��ϴ� ��");
	}


	/*
	protected void prepareRecipe() {
		boilWater();
		brewCoffeGrinds();
		pourInCup();
		addSugarAndMilk();
	}
	*/
	
	/*
	public void brewCoffeGrinds() {
		System.out.println("���͸� ���ؼ� Ŀ�Ǹ� ������� ��");
	}
	*/
	
	/*
	public void addSugarAndMilk() {
		System.out.println("������ ������ �߰��ϴ� ��");
	}
	*/
}

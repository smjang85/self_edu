package design_pattern_edu.template_method_pattern;

public class Tea extends CaffeineBeverage{

	@Override
	public void brew() {
		System.out.println("���� ������� ��");
		
	}
	
	@Override
	public void addCondiments() {
		System.out.println("������ �߰��ϴ� ��");
		
	}


	/*
	protected void prepareRecipe() {
		boilWater();
		steepTeaBag();
		pourInCup();
		addLemon();
	}
	
	public void steepTeaBag() {
		System.out.println("���� ������� ��");
	}
	
	public void addLemon() {
		System.out.println("������ �߰��ϴ� ��");
	}
	*/
}

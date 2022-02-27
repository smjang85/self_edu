package design_pattern_edu.template_method_pattern;

public class Tea extends CaffeineBeverage{

	@Override
	public void brew() {
		System.out.println("차를 우려내는 중");
		
	}
	
	@Override
	public void addCondiments() {
		System.out.println("레몬을 추가하는 중");
		
	}


	/*
	protected void prepareRecipe() {
		boilWater();
		steepTeaBag();
		pourInCup();
		addLemon();
	}
	
	public void steepTeaBag() {
		System.out.println("차를 우려내는 중");
	}
	
	public void addLemon() {
		System.out.println("레몬을 추가하는 중");
	}
	*/
}

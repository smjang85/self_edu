package design_pattern_edu.template_method_pattern;

/*
 * 8. ���ø� �޼ҵ� ����
 * �޼ҵ忡�� �˰����� ����� �����մϴ�.
 * �˰����� ���� �ܰ� �� �Ϻδ� ����Ŭ�������� ������ �� �ֽ��ϴ�. 
 * ���ø� �޼ҵ带 �̿��ϸ� �˰����� ������ �״�� �����ϸ鼭 ����Ŭ�������� Ư�� �ܰ踦 �������� �� �ֽ��ϴ�.
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
		System.out.println("�� ���̴� ��");
	}
	
	public void pourInCup() {
		System.out.println("�ſ� ������ ��");
	}
	
	public boolean customerWantsCondiments() {
		return true;
	}
}

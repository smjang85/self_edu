package design_pattern_edu.template_method_pattern;

/*
 * 8. ���ø� �޼ҵ� ����
 * �޼ҵ忡�� �˰����� ����� �����մϴ�.
 * �˰����� ���� �ܰ� �� �Ϻδ� ����Ŭ�������� ������ �� �ֽ��ϴ�. 
 * ���ø� �޼ҵ带 �̿��ϸ� �˰����� ������ �״�� �����ϸ鼭 ����Ŭ�������� Ư�� �ܰ踦 �������� �� �ֽ��ϴ�.
 * 
 * ### ������ ��Ģ ###
 * �渮��� ��Ģ -> ( ���丮 �޼ҵ�, ������
 * ���� �������� ������. ���� ���� �帮�ڽ��ϴ�.
 */

public class BeverageTestDrive {
	public static void main(String[] args) {
		TeaWithHook teaHook = new TeaWithHook();
		CoffeWithHook coffeeHook = new CoffeWithHook();
		
		System.out.println("\n�� �غ���...");
		teaHook.prepareRecipe();
		
		System.out.println("\nĿ�� �غ���...");
		coffeeHook.prepareRecipe();
	}
}

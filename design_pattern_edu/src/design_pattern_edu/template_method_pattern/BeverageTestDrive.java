package design_pattern_edu.template_method_pattern;

/*
 * 8. 템플릿 메소드 패턴
 * 메소드에서 알고리즘의 골격을 정의합니다.
 * 알고리즘의 여러 단계 중 일부는 서브클래스에서 구현할 수 있습니다. 
 * 템플릿 메소드를 이용하면 알고리즘의 구조는 그대로 유지하면서 서브클래스에서 특정 단계를 재정의할 수 있습니다.
 * 
 * ### 디자인 원칙 ###
 * 헐리우드 원칙 -> ( 팩토리 메소드, 옵저버
 * 먼저 연락하지 마세요. 저희가 연락 드리겠습니다.
 */

public class BeverageTestDrive {
	public static void main(String[] args) {
		TeaWithHook teaHook = new TeaWithHook();
		CoffeWithHook coffeeHook = new CoffeWithHook();
		
		System.out.println("\n차 준비중...");
		teaHook.prepareRecipe();
		
		System.out.println("\n커피 준비중...");
		coffeeHook.prepareRecipe();
	}
}

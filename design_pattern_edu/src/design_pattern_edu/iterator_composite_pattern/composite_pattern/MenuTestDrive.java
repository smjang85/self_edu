package design_pattern_edu.iterator_composite_pattern.composite_pattern;

import design_pattern_edu.iterator_composite_pattern.composite_pattern.component.MenuComponent;
import design_pattern_edu.iterator_composite_pattern.composite_pattern.menu.Menu;

/*
 * 9-2. 컴포지트 패턴
 * 객체들을 트리 구조로 구성하여 부분과 전체를 나타내는 계층구조로 만들 수 있습니다.
 * 이 패턴을 이용하면 클라이언트에서 개별 객체와 다른 객체들로 구성된 복합 객체를 똑같은 방법으로 다룰 수 있습니다.
 * 
 * ### 디자인 원칙 ###
 */
public class MenuTestDrive {
	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("팬케이크 하우스 메뉴", "아침 메뉴");
		MenuComponent dinerMenu = new Menu("객체마을 식당 메뉴", "점심 메뉴");
		MenuComponent cafeMenu = new Menu("카페 메뉴", "저녘 메뉴");
		MenuComponent dessertMenu = new Menu("디저트 메뉴", "디저트를 즐겨 보세요!");
		
		MenuComponent allMenus = new Menu("전체 메뉴", "전체 메뉴");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		dinerMenu.add(new MenuItem("파스타","마리나라 소스 스파케티. 효모빵도 드립니다.",true,3.89));
		dinerMenu.add(dessertMenu);
		
		dessertMenu.add(new MenuItem("애플 파이","바삭바삭한 크러스트에 바닐라 아이스크림이 얹혀 있는 애플 파이",true,1.59));
		
		Waitress waitress = new Waitress(allMenus);
		//waitress.printMenu();
		
		waitress.printVegetarianMenu();
	}
}

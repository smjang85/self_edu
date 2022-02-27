package design_pattern_edu.iterator_composite_pattern.iterator_pattern;

import java.util.ArrayList;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.CafeMenu;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.DinerMenu;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.Menu;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.PancakeHouseMenu;

/*
 * 9-1. 이터레이터 패턴
 * 컬렉션 구현 방법을 노출시키지 않으면서도 그 집합체 안에 들어있는 모든 항목에 접근할 수 있게 해 주는 방법을 제공해 줍니다.
 * 
 * ### 디자인 원칙 ###
 * 클래스를 바꾸는 이유는 한 가지 뿐이어야 한다.
 */
public class MenuTestDrive {
	public static void main(String[] args) {
		//Menu pancakeHouseMenu = new PancakeHouseMenu();
		//Menu dinerMenu = new DinerMenu();
		//Menu cafeMenu = new CafeMenu();
		//Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
		
		ArrayList<Menu> menus = new ArrayList<Menu>();
		menus.add(new PancakeHouseMenu());
		menus.add(new DinerMenu());
		menus.add(new CafeMenu());
		
		Waitress waitress = new Waitress(menus);
		waitress.printMenu();
	}
}

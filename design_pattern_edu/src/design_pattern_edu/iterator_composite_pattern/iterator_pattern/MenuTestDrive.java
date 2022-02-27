package design_pattern_edu.iterator_composite_pattern.iterator_pattern;

import java.util.ArrayList;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.CafeMenu;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.DinerMenu;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.Menu;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.PancakeHouseMenu;

/*
 * 9-1. ���ͷ����� ����
 * �÷��� ���� ����� �����Ű�� �����鼭�� �� ����ü �ȿ� ����ִ� ��� �׸� ������ �� �ְ� �� �ִ� ����� ������ �ݴϴ�.
 * 
 * ### ������ ��Ģ ###
 * Ŭ������ �ٲٴ� ������ �� ���� ���̾�� �Ѵ�.
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

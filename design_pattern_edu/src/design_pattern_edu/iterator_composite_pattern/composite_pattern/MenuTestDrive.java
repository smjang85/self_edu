package design_pattern_edu.iterator_composite_pattern.composite_pattern;

import design_pattern_edu.iterator_composite_pattern.composite_pattern.component.MenuComponent;
import design_pattern_edu.iterator_composite_pattern.composite_pattern.menu.Menu;

/*
 * 9-2. ������Ʈ ����
 * ��ü���� Ʈ�� ������ �����Ͽ� �κа� ��ü�� ��Ÿ���� ���������� ���� �� �ֽ��ϴ�.
 * �� ������ �̿��ϸ� Ŭ���̾�Ʈ���� ���� ��ü�� �ٸ� ��ü��� ������ ���� ��ü�� �Ȱ��� ������� �ٷ� �� �ֽ��ϴ�.
 * 
 * ### ������ ��Ģ ###
 */
public class MenuTestDrive {
	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("������ũ �Ͽ콺 �޴�", "��ħ �޴�");
		MenuComponent dinerMenu = new Menu("��ü���� �Ĵ� �޴�", "���� �޴�");
		MenuComponent cafeMenu = new Menu("ī�� �޴�", "���� �޴�");
		MenuComponent dessertMenu = new Menu("����Ʈ �޴�", "����Ʈ�� ��� ������!");
		
		MenuComponent allMenus = new Menu("��ü �޴�", "��ü �޴�");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		dinerMenu.add(new MenuItem("�Ľ�Ÿ","�������� �ҽ� ������Ƽ. ȿ�𻧵� �帳�ϴ�.",true,3.89));
		dinerMenu.add(dessertMenu);
		
		dessertMenu.add(new MenuItem("���� ����","�ٻ�ٻ��� ũ����Ʈ�� �ٴҶ� ���̽�ũ���� ���� �ִ� ���� ����",true,1.59));
		
		Waitress waitress = new Waitress(allMenus);
		//waitress.printMenu();
		
		waitress.printVegetarianMenu();
	}
}

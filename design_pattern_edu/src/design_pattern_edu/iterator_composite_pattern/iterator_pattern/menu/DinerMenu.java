package design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu;

import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.MenuItem;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.iterator.impl.DinerMenuIterator;

public class DinerMenu implements Menu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("ä�������ڿ� BLT"	, "��� ����(�Ĺ���) ������, ����, �丶�並 ���� �޴�"	, true, 2.99);
		addItem("BLT"			, "��� ���� ������, ����, �丶�並 ���� �޴�"			, false, 2.99);
		addItem("������ ����"		, "���� �����带 ����� ������ ����"					, false, 3.29);
		addItem("�ֵ���"			, "���ũ���Ʈ, ���� ���, ����, ��� ��鿩�� �ֵ���"	, false, 3.05);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if(numberOfItems >= MAX_ITEMS) {
			System.err.println("�˼��մϴ�, �޴��� �� á���ϴ�. �� �̻� �߰��� �� �����ϴ�.");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	/*
	public MenuItem[] getMenuItems() {
		return menuItems;
	}
	*/

	@Override
	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}

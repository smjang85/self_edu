package design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu;

import java.util.Hashtable;
import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.MenuItem;

public class CafeMenu implements Menu {
	Hashtable menuItems = new Hashtable();
	
	public CafeMenu() {
		addItem("���� ���ſ� ���� ������"	, "��л�, ����, �丶��, ����Ƣ���� ÷���� ���� ����"	, true, 3.99);
		addItem("������ ����"	, "�����尡 ��鿩�� ������ ����"	, false, 3.69);
		addItem("������"	, "�� ������� ���, ����ī���� ��鿩�� Ǫ���� ������"	, true, 4.29);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}
	
	/*
	public Hashtable getItem() {
		return menuItems;
	}
	*/
	public Iterator createIterator() {
		return menuItems.values().iterator();
	}

}

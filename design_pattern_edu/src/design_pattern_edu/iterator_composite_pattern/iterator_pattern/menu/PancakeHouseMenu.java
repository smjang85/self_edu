package design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu;

import java.util.ArrayList;
import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.MenuItem;

public class PancakeHouseMenu implements Menu {
	ArrayList<MenuItem> menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		
		addItem("K&B ������ũ ��Ʈ"		, "��ũ����� ���׿� �佺Ʈ�� ��鿩�� ������ũ"			, true	, 2.99);
		addItem("���ַ� �����̽� ��Ʈ"	, "�ް� �Ķ��̿� �ҽ����� ��鿩�� ������ũ"			, false	, 2.99);
		addItem("��纣�� ������ũ"		, "�ż��� ��纣���� ��纣�� �÷����� ���� ������ũ"		, true	, 3.49);
		addItem("����"				, "����, ���⿡ ���� ��纣���� ���⸦ ���� �� �ֽ��ϴ�."	, true	, 3.59);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	/*
	public ArrayList getMenuItems() {
		return menuItems;
	}
	*/
	
	public Iterator createIterator() {
		return menuItems.iterator();
	}

}

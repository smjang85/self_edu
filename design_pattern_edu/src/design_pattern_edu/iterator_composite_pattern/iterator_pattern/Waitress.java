package design_pattern_edu.iterator_composite_pattern.iterator_pattern;

import java.util.ArrayList;
import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu.Menu;

public class Waitress {
	//PancakeHouseMenu pacakeHouseMenu;
	//DinerMenu dinerMenu;
	//Menu pacakeHouseMenu;
	//Menu dinerMenu;
	//Menu cafemenu;
	/*
	public Waitress(Menu pacakeHouseMenu, Menu dinerMenu, Menu cafemenu) {
		this.dinerMenu = dinerMenu;
		this.pacakeHouseMenu = pacakeHouseMenu;
		this.cafemenu = cafemenu;
	}
	*/
	
	/*
	public void printMenu() {
		Iterator pancakeIterator = pacakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		Iterator cafeIterator = dinerMenu.createIterator();
		
		System.out.println("메뉴\n---\n아침메뉴");
		printMenu(pancakeIterator);
		System.out.println("메뉴\n---\n점심메뉴");
		printMenu(dinerIterator);
		System.out.println("메뉴\n---\n저녘메뉴");
		printMenu(cafeIterator);
	}
	*/
	
	
	ArrayList<Menu> menus;
	public Waitress(ArrayList<Menu> menus) {
		this.menus = menus;
	}
	
	public void printMenu() {
		Iterator<Menu> menuIterator = menus.iterator();
		while(menuIterator.hasNext()) {
			Menu menu = menuIterator.next();
			printMenu(menu.createIterator());
		}
	}
	
	private void printMenu(Iterator<MenuItem> iterator) {
		while(iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

}

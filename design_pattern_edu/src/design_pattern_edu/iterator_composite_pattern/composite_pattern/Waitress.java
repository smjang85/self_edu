package design_pattern_edu.iterator_composite_pattern.composite_pattern;

import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.composite_pattern.component.MenuComponent;

public class Waitress {
	
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}
	
	public void printVegetarianMenu() {
		Iterator<MenuComponent> iterator = allMenus.createIterator();
		System.out.println("\nVEGETARIAN MENU\n---");
		while(iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			try {
				if(menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			}catch(UnsupportedOperationException e) { }
		}
	}

}

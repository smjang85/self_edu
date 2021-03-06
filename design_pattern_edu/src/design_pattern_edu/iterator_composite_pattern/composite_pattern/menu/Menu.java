package design_pattern_edu.iterator_composite_pattern.composite_pattern.menu;

import java.util.ArrayList;
import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.composite_pattern.component.MenuComponent;
import design_pattern_edu.iterator_composite_pattern.composite_pattern.iterator.CompositeIterator;

public class Menu extends MenuComponent {
	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	String name;
	String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void print() {
		System.out.println("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
		
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while(iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			menuComponent.print();
		}
	}
	
	public Iterator createIterator() {
		return new CompositeIterator(menuComponents.iterator());
	}
	
}

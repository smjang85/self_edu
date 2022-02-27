package design_pattern_edu.iterator_composite_pattern.composite_pattern.iterator;

import java.util.Iterator;
import java.util.Stack;

import design_pattern_edu.iterator_composite_pattern.composite_pattern.component.MenuComponent;
import design_pattern_edu.iterator_composite_pattern.composite_pattern.menu.Menu;

public class CompositeIterator implements Iterator {
	Stack<Iterator> stack = new Stack();
	
	public CompositeIterator(Iterator<MenuComponent> iterator) {
		stack.push(iterator);
	}
	
	public Object next() {
		if(hasNext()) {
			Iterator<MenuComponent> iterator = (Iterator<MenuComponent>) stack.peek();
			MenuComponent component = iterator.next();
			if(component instanceof Menu) {
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		}
	}
	
	public boolean hasNext() {
		if(stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if(!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}

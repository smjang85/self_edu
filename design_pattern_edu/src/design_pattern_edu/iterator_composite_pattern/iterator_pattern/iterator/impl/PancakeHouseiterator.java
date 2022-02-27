package design_pattern_edu.iterator_composite_pattern.iterator_pattern.iterator.impl;

import java.util.ArrayList;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.MenuItem;
import design_pattern_edu.iterator_composite_pattern.iterator_pattern.iterator.Iterator;

public class PancakeHouseiterator implements Iterator {
	ArrayList<MenuItem> items;
	int position = 0;
	
	public PancakeHouseiterator(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	public Object next() {
		MenuItem menuItem = items.get(position);
		position = position + 1;
		return menuItem;
	}
	
	public boolean hasNext() {
		if(position >= items.size() || items.get(position) == null) {
			return false;
		} else {
			return true;
		}
	}
}

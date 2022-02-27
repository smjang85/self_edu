package design_pattern_edu.iterator_composite_pattern.iterator_pattern.iterator.impl;

import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.MenuItem;

public class DinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position = 0;
	
	public DinerMenuIterator(MenuItem[] items) {
		this.items = items;
	}
	
	public Object next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}
	
	public boolean hasNext() {
		if(position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void remove() {
		if(position <= 0) {
			throw new IllegalStateException("next()�� �ѹ��� ȣ������ ���� ���¿����� ������ �� �����ϴ�.");
		}
		if(items[position-1] != null) {
			for(int i = position-1; i< (items.length - 1); i++) {
				items[i] = items[i+1];
			}
			items[items.length-1] = null;
		}
	}
}

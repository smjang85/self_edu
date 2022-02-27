package design_pattern_edu.iterator_composite_pattern.iterator_pattern.menu;

import java.util.Iterator;

import design_pattern_edu.iterator_composite_pattern.iterator_pattern.MenuItem;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}

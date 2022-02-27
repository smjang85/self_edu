package design_pattern_edu.iterator_composite_pattern.composite_pattern.iterator;

import java.util.Iterator;

public class NullIterator implements Iterator {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}

}

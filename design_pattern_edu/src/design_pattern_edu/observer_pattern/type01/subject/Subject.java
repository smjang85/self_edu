package design_pattern_edu.observer_pattern.type01.subject;

import design_pattern_edu.observer_pattern.type01.observer.Observer;

public interface Subject {
	public void regsterObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

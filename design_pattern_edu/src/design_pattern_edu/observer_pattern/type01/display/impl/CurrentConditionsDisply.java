package design_pattern_edu.observer_pattern.type01.display.impl;

import design_pattern_edu.observer_pattern.type01.display.DisplayElement;
import design_pattern_edu.observer_pattern.type01.observer.Observer;
import design_pattern_edu.observer_pattern.type01.subject.Subject;

public class CurrentConditionsDisply implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisply(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.regsterObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + "% humidity");
	}
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
		
	}

}

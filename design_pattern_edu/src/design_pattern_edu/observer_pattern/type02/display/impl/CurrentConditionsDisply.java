package design_pattern_edu.observer_pattern.type02.display.impl;

import java.util.Observable;
import java.util.Observer;

import design_pattern_edu.observer_pattern.type02.display.DisplayElement;
import design_pattern_edu.observer_pattern.type02.subject.WeatherData;

public class CurrentConditionsDisply implements Observer, DisplayElement{
	Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisply(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + "% humidity");
	}
	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
}

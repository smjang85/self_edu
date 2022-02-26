package design_pattern_edu.observer_pattern.type01;

import design_pattern_edu.observer_pattern.type01.display.impl.CurrentConditionsDisply;
import design_pattern_edu.observer_pattern.type01.display.impl.HeatIndexDisplay;
import design_pattern_edu.observer_pattern.type01.subject.impl.WeatherData;

/*
 * 2. 옵저버 패턴(Observer Pattern)
 * 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many)의존성을 정의합니다.
 * 
 * ### 디자인 원칙 ###
 * 서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야 한다.
 *  -> 느슨하게 결합하는 디자인을 사용하면 변경 사항이 생겨도 무난히 처리할 수 있는 유연한 객체지향 시스템을 구축할 수 있습니다. 객체 사이의 상호의존성을 최소화할 수 있기 때문입니다.
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisply currentDisplay = new CurrentConditionsDisply(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}

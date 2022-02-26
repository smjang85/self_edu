package design_pattern_edu.observer_pattern.type02;

import design_pattern_edu.observer_pattern.type02.display.impl.CurrentConditionsDisply;
import design_pattern_edu.observer_pattern.type02.subject.WeatherData;

/*
 * 2. 옵저버 패턴(Observer Pattern)
 * 자바 내장 옵저버 패턴 사용
 * 
 * ### 단점 ###
 * Observale은 클래스이다
 *  -> 1) 서브클래스를 만들어야 한다. 이미 다른 클래스를 상속하면 기능을 추가할 수 없다.
 *  -> 2) 인터페이스가 없기 때문에 다른 구현으로 바꿀 수 없다.
 * Observable 클래스의 핵심 메소드를 외부에서 호출할 수 없다.
 *  -> setChanged 메소드가 protected로 선언되어 있어 사용에 제한적
 * 
 * 상황에 따라 type01(직접구현), type02(javaAPI)를 사용
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisply currentDisplay = new CurrentConditionsDisply(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}

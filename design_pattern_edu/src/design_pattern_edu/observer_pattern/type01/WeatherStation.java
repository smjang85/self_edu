package design_pattern_edu.observer_pattern.type01;

import design_pattern_edu.observer_pattern.type01.display.impl.CurrentConditionsDisply;
import design_pattern_edu.observer_pattern.type01.display.impl.HeatIndexDisplay;
import design_pattern_edu.observer_pattern.type01.subject.impl.WeatherData;

/*
 * 2. ������ ����(Observer Pattern)
 * �� ��ü�� ���°� �ٲ�� �� ��ü�� �����ϴ� �ٸ� ��ü������ ������ ���� �ڵ����� ������ ���ŵǴ� ������� �ϴ��(one-to-many)�������� �����մϴ�.
 * 
 * ### ������ ��Ģ ###
 * ���� ��ȣ�ۿ��� �ϴ� ��ü ���̿����� �����ϸ� �����ϰ� �����ϴ� �������� ����ؾ� �Ѵ�.
 *  -> �����ϰ� �����ϴ� �������� ����ϸ� ���� ������ ���ܵ� ������ ó���� �� �ִ� ������ ��ü���� �ý����� ������ �� �ֽ��ϴ�. ��ü ������ ��ȣ�������� �ּ�ȭ�� �� �ֱ� �����Դϴ�.
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

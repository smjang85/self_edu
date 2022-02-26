package design_pattern_edu.observer_pattern.type02;

import design_pattern_edu.observer_pattern.type02.display.impl.CurrentConditionsDisply;
import design_pattern_edu.observer_pattern.type02.subject.WeatherData;

/*
 * 2. ������ ����(Observer Pattern)
 * �ڹ� ���� ������ ���� ���
 * 
 * ### ���� ###
 * Observale�� Ŭ�����̴�
 *  -> 1) ����Ŭ������ ������ �Ѵ�. �̹� �ٸ� Ŭ������ ����ϸ� ����� �߰��� �� ����.
 *  -> 2) �������̽��� ���� ������ �ٸ� �������� �ٲ� �� ����.
 * Observable Ŭ������ �ٽ� �޼ҵ带 �ܺο��� ȣ���� �� ����.
 *  -> setChanged �޼ҵ尡 protected�� ����Ǿ� �־� ��뿡 ������
 * 
 * ��Ȳ�� ���� type01(��������), type02(javaAPI)�� ���
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

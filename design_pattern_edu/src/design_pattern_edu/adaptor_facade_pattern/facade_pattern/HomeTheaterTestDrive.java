package design_pattern_edu.adaptor_facade_pattern.facade_pattern;

import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.Amplifier;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.CdPlayer;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.DvdPlayer;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.PopcornPopper;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.Projector;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.Screen;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.TheaterLights;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.Tuner;
import design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater.facade.HomeTheaterFacade;

/*
 * 7-2. �ۻ�� ����
 * � ����ý����� �Ϸ��� �������̽��� ���� ���յ� �������̽��� �����մϴ�.
 * �ۻ�忡�� ����� �������̽��� �����ϱ� ������ ����ý����� �� ���� ����� �� �ֽ��ϴ�.
 * 
 * ### ������ ��Ģ ###
 * �ּ� ���� ��Ģ - ���� ģ�� ģ���ϰ� ����϶�.
 */
public class HomeTheaterTestDrive {
	public static void main(String[] args) {
		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		DvdPlayer dvd = new DvdPlayer();
		CdPlayer cd = new CdPlayer();
		Projector projector = new Projector();
		TheaterLights lights = new TheaterLights(); 
		Screen screen = new Screen();
		PopcornPopper popper = new PopcornPopper();
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, lights, screen, popper);
		
		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();
	}
}

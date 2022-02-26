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
 * 7-2. 퍼사드 패턴
 * 어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공합니다.
 * 퍼사드에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할 수 있습니다.
 * 
 * ### 디자인 원칙 ###
 * 최소 지식 원칙 - 정말 친한 친구하고만 얘기하라.
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

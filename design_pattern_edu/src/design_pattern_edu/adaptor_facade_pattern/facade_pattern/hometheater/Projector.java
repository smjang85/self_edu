package design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater;

public class Projector {
	DvdPlayer dvdPlayer;
	
	public void on() {
		System.out.println("Projector On");
	}
	
	public void off() {
		System.out.println("Projector Off");
	}
	
	public void tvMode() {
		System.out.println("Projector TV MODE");
	}
	
	public void wideScreenMode() {
		System.out.println("Projector WIDE SCREEN MODE");
	}
}

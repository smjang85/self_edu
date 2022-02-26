package design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater;

public class CdPlayer {
	Amplifier amplifier;
	
	public void on() {
		System.out.println("CdPlayer On");
	}
	
	public void off() {
		System.out.println("CdPlayer Off");
	}
	
	public void eject() {
		System.out.println("CdPlayer Eject");
	}
	
	public void pause() {
		System.out.println("CdPlayer Pause");
	}
	
	public void play() {
		System.out.println("CdPlayer Play");
	}
	
	public void stop() {
		System.out.println("CdPlayer Stop");
	}
	
}

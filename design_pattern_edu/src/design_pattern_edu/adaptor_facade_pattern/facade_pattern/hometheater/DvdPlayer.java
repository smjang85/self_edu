package design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater;

public class DvdPlayer {
	Amplifier amplifier;
	
	public void on() {
		System.out.println("DvdPlayer On");
	}
	
	public void off() {
		System.out.println("DvdPlayer Off");
	}
	
	public void eject() {
		System.out.println("DvdPlayer Eject");
	}
	
	public void pause() {
		System.out.println("DvdPlayer Pause");
	}
	
	public void play(String movieName) {
		System.out.println("DvdPlayer Play :" + movieName);
	}
	
	public void setSurroundAudio() {
		System.out.println("DvdPlayer Set SurroundAudio");
	}
	
	public void setTwoChannelAudio() {
		
	}
	
	public void stop() {
		
	}
	
}

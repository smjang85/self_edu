package design_pattern_edu.command_pattern.receiver;

public class Stereo {
	int volume;
	String target;
	
	public Stereo(String target) {
		this.target = target;
	}
	
	public void on() {
		System.out.println("Stereo [" + target + "] is Open");
	}
	
	public void off() {
		System.out.println("Stereo [" + target + "] is Off");
	}
	
	public void setCd() {
		System.out.println("Stereo [" + target + "] set CD");
	}
	
	public void setDvd() {
		System.out.println("Stereo [" + target + "] set Dvd");
	}
	
	public void setRadio() {
		System.out.println("Stereo [" + target + "] set Radio");
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println("Stereo [" + target + "] set Volume :" + volume);
	}
}

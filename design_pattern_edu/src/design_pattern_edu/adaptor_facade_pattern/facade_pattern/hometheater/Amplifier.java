package design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater;

public class Amplifier {
	Tuner tuner;
	DvdPlayer dvdplayer;
	CdPlayer cdplayer;
	
	public void on() {
		System.out.println("Amplifier is On");
	}
	
	public void off() {
		System.out.println("Amplifier is Off");
	}
	
	public void setCd(CdPlayer cdplayer) {
		this.cdplayer = cdplayer;
	}
	
	public void setDvd(DvdPlayer dvdplayer) {
		this.dvdplayer = dvdplayer;
	}
	
	public void setTuner(Tuner tuner) {
		this.tuner = tuner;
	}
	
	public void setStereoSound() {
		System.out.println("Amplifier set StereoSound");
	}
	
	public void setSurroundSound() {
		System.out.println("Amplifier set SurroundSound");
	}
	
	public void setVolume(int volume) {
		System.out.println("Amplifier set Volume :" + volume);
	}
	
}

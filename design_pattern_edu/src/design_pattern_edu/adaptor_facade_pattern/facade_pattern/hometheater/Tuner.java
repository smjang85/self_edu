package design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater;

public class Tuner {
	Amplifier amplifier;
	
	public void on() {
		System.out.println("Tuner is On");
	}
	
	public void off() {
		System.out.println("Tuner is Off");
	}
	
	public void setAm() {
		System.out.println("Tuner set Am");
	}
	
	public void setFm() {
		System.out.println("Tuner set Fm");
	}
	
	public void setFrequency() {
		System.out.println("Tuner set Frequency");
	}
}

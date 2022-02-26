package design_pattern_edu.adaptor_facade_pattern.facade_pattern.hometheater;

public class TheaterLights {
	
	public void on() {
		System.out.println("Theater Lights is On");
	}
	
	public void off() {
		System.out.println("Theater Lights is Off");
	}
	
	public void dim(int dim) {
		System.out.println("Theater Lights is dimming to" + dim + "%");
	}
	
}

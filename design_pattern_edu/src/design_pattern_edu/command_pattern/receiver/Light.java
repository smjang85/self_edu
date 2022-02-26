package design_pattern_edu.command_pattern.receiver;

public class Light {
	String target;
	
	public Light(String target) {
		this.target = target;
	}
	
	public void on() {
		System.out.println("Light is [" + target + "] On");
	}
	
	public void off() {
		System.out.println("Light is [" + target + "] Off");
	}
}

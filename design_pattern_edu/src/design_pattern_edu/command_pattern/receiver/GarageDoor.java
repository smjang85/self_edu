package design_pattern_edu.command_pattern.receiver;

public class GarageDoor {
	String target;
	
	public GarageDoor(String target) {
		this.target = target;
	}
	
	public void up() {
		System.out.println("GarageDoor [" + target + "] is Open");
	}
	
	public void down() {
		System.out.println("GarageDoor [" + target + "] is Close");
	}
	
	public void stop() {
		System.out.println("GarageDoor [" + target + "] is Stop");
	}
	
	public void lightOn() {
		System.out.println("GarageDoor [" + target + "] is lightOn");
	}
	
	public void lightOff() {
		System.out.println("GarageDoor [" + target + "] is lightOff");
	}
}

package design_pattern_edu.command_pattern.receiver;



public class CeilingFan {
	String location;
	Speed speed;
	public static enum Speed{HIGH, MEDIUM, LOW, OFF}
	
	public CeilingFan(String target) {
		this.speed = Speed.OFF;
		this.location = target;
	}
	
	public void high() {
		this.speed = Speed.HIGH;
		System.out.println("CelingFan [" + location + "] set High");
	}
	
	public void medium() {
		this.speed = Speed.MEDIUM;
		System.out.println("CelingFan [" + location + "] set Medium");
	}
	
	public void low() {
		this.speed = Speed.LOW;
		System.out.println("CelingFan [" + location + "] set Low");
	}
	
	public void off() {
		this.speed = Speed.OFF;
		System.out.println("CelingFan [" + location + "] set Off");
	}
	
	public Speed getSpeed() {
		System.out.println("CelingFan [" + location + "] speed is " + speed.toString());
		return speed;
	}
	
}

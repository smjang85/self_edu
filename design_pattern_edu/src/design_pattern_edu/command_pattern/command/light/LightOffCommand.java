package design_pattern_edu.command_pattern.command.light;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.receiver.Light;

public class LightOffCommand implements Command {
	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.off();
	}
	
	@Override
	public void undo() {
		light.on();
	}
}

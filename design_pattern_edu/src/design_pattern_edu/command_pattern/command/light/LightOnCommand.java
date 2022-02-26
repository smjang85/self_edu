package design_pattern_edu.command_pattern.command.light;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.receiver.Light;

public class LightOnCommand implements Command {
	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.on();
	}
	
	@Override
	public void undo() {
		light.off();
	}
}

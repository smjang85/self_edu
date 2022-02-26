package design_pattern_edu.command_pattern.command.garage_door;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.receiver.GarageDoor;

public class GarageDoorDownCommand implements Command{
	GarageDoor garageDoor;
	
	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.down();		
	}

	@Override
	public void undo() {
		garageDoor.up();
	}
	
}

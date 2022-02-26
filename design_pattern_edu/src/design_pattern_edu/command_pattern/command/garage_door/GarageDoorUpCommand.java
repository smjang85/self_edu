package design_pattern_edu.command_pattern.command.garage_door;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.receiver.GarageDoor;

public class GarageDoorUpCommand implements Command{
	GarageDoor garageDoor;
	
	public GarageDoorUpCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.up();		
	}
	
	@Override
	public void undo() {
		garageDoor.down();
	}
}

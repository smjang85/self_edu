package design_pattern_edu.command_pattern.command.ceiling;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.receiver.CeilingFan;
import design_pattern_edu.command_pattern.receiver.CeilingFan.Speed;

public class CeilingFanOffCommand implements Command {
	CeilingFan ceilingFan;
	Speed prevSpeed;
	
	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		this.ceilingFan =ceilingFan;
	}
	
	public void execute() {
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.off();
	}

	@Override
	public void undo() {
		if(prevSpeed == Speed.HIGH) {
			ceilingFan.high();
		}else if(prevSpeed == Speed.MEDIUM) {
			ceilingFan.medium();
		}else if(prevSpeed == Speed.LOW) {
			ceilingFan.low();
		}else if(prevSpeed == Speed.OFF) {
			ceilingFan.off();
		}
	}
}

package design_pattern_edu.command_pattern.command.stereo;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.receiver.Stereo;

public class StereoOffCommand implements Command {
	Stereo stereo;
	
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	public void execute() {
		stereo.off();
	}
	
	@Override
	public void undo() {
		stereo.on();
	}
}

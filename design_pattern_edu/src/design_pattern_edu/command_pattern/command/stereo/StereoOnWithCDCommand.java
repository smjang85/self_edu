package design_pattern_edu.command_pattern.command.stereo;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.receiver.Stereo;

public class StereoOnWithCDCommand implements Command {
	Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(11);
	}
	
	@Override
	public void undo() {
		stereo.off();
	}
}

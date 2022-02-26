package design_pattern_edu.command_pattern.invoker;

import design_pattern_edu.command_pattern.command.Command;

// ÀÎº¸Ä¿ °´Ã¼
public class SimpleRemoteControl {
	Command slot;
	
	public SimpleRemoteControl() {}
	
	public void setCommand(Command command) {
		slot = command;
	}
	
	public void buttonWasPressed() {
		slot.execute();
	}
}

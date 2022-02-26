package design_pattern_edu.command_pattern.command;

public class MacroCommand implements Command {
	Command[] commands;
	
	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}
	
	public void execute() {
		for(int i = 0; i < commands.length; i++) {
			commands[i].execute();
		}
	}

	@Override
	public void undo() {
		for(int i = 0; i < commands.length; i++) {
			commands[i].undo();
		}
	}
}

package design_pattern_edu.state_pattern.after;

import design_pattern_edu.state_pattern.after.model.GumballMachine;

public class GumballMachineTestDrive {
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
	}
}

package design_pattern_edu.state_pattern.before;

public class GumballMachineTestDrive {
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.ejectQuarter();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		gumballMachine.ejectQuarter();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
	}
}

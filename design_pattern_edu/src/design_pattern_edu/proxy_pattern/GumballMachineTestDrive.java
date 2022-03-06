package design_pattern_edu.proxy_pattern;

import design_pattern_edu.proxy_pattern.model.GumballMachine;

public class GumballMachineTestDrive {
	public static void main(String[] args) {
		int count = 0;
		if(args.length > 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}
		count = Integer.parseInt(args[1]);
		
		GumballMachine gumballMachine = new GumballMachine(args[0] , count);
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		gumballMachine.insertQuater();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		GumballMonitor monitor = new GumballMonitor(gumballMachine);
		monitor.report();
		
	}
}

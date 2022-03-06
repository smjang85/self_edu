package design_pattern_edu.proxy_pattern.state.impl;

import design_pattern_edu.proxy_pattern.model.GumballMachine;
import design_pattern_edu.proxy_pattern.state.State;

public class NoQuaterState implements State{
	GumballMachine gumballMachine;
	
	public NoQuaterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuater() {
		System.out.println("������ �����̽��ϴ�.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuater() {
		System.out.println("������ �־��ּ���.");
	}

	@Override
	public void turnCrank() {
		System.out.println("������ �־��ּ���.");
		
	}

	@Override
	public void dispense() {
		System.out.println("������ �־��ּ���.");
	}

}

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
		System.out.println("동전을 넣으셨습니다.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuater() {
		System.out.println("동전을 넣어주세요.");
	}

	@Override
	public void turnCrank() {
		System.out.println("동전을 넣어주세요.");
		
	}

	@Override
	public void dispense() {
		System.out.println("동전을 넣어주세요.");
	}

}

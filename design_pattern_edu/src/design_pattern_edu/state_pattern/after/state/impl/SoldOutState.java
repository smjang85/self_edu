package design_pattern_edu.state_pattern.after.state.impl;

import design_pattern_edu.state_pattern.after.model.GumballMachine;
import design_pattern_edu.state_pattern.after.state.State;

public class SoldOutState implements State{
	GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuater() {
		System.out.println("매진되었습니다. 다음 기회에 이용해주세요.");
		
	}

	@Override
	public void ejectQuater() {
		System.out.println("동전을 넣지 않으셨습니다. 동전이 반환되지 않습니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("매진되었습니다.");
		
	}

	@Override
	public void dispense() {
		System.out.println("매진입니다.");
	}
}

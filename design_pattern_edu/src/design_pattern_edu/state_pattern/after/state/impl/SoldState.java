package design_pattern_edu.state_pattern.after.state.impl;

import design_pattern_edu.state_pattern.after.model.GumballMachine;
import design_pattern_edu.state_pattern.after.state.State;

public class SoldState implements State{
	GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuater() {
		System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다.");
	}

	@Override
	public void ejectQuater() {
		System.out.println("이미 알멩이를 뽑으셨습니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("손잡이는 한 번만 돌려주세요.");
	}

	@Override
	public void dispense() {
		/*
		 * System.out.println("알멩이가 나가고 있습니다.");
		 * gumballMachine.setCount(gumballMachine.getCount() - 1);
		 */
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuaterState());
		}else {
			System.out.println("더 이상 얼맹이가 없습니다.");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

}

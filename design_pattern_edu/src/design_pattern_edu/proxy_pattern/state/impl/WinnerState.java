package design_pattern_edu.proxy_pattern.state.impl;

import design_pattern_edu.proxy_pattern.model.GumballMachine;
import design_pattern_edu.proxy_pattern.state.State;

public class WinnerState implements State{
	GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine) {
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
		System.out.println("축하드립니다! 알맹이를 하나 더 받으실 수 있습니다.");
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if(gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuaterState());
			}else {
				System.out.println("더 이상 얼맹이가 없습니다.");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}
}

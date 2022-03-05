package design_pattern_edu.state_pattern.after.state.impl;

import java.util.Random;

import design_pattern_edu.state_pattern.after.model.GumballMachine;
import design_pattern_edu.state_pattern.after.state.State;

public class HasQuaterState implements State{
	Random randomWinner = new Random(System.currentTimeMillis());
	GumballMachine gumballMachine;
	
	public HasQuaterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuater() {
		System.out.println("������ �� ���� �־��ּ���.");
	}

	@Override
	public void ejectQuater() {
		System.out.println("������ ��ȯ�˴ϴ�.");
		gumballMachine.setState(gumballMachine.getNoQuaterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("�����̸� �����̽��ϴ�.");
		int winner = randomWinner.nextInt(10);
		if((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		}else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("�˸��̰� ���� �� �����ϴ�.");
	}
}

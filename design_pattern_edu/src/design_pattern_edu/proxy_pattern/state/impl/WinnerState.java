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
		System.out.println("��� ��ٷ� �ּ���. �˸��̰� ������ �ֽ��ϴ�.");
	}

	@Override
	public void ejectQuater() {
		System.out.println("�̹� �˸��̸� �����̽��ϴ�.");
	}

	@Override
	public void turnCrank() {
		System.out.println("�����̴� �� ���� �����ּ���.");
	}

	@Override
	public void dispense() {
		System.out.println("���ϵ帳�ϴ�! �˸��̸� �ϳ� �� ������ �� �ֽ��ϴ�.");
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if(gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuaterState());
			}else {
				System.out.println("�� �̻� ����̰� �����ϴ�.");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}
}

package design_pattern_edu.proxy_pattern.state.impl;

import design_pattern_edu.proxy_pattern.model.GumballMachine;
import design_pattern_edu.proxy_pattern.state.State;

public class SoldOutState implements State{
	GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuater() {
		System.out.println("�����Ǿ����ϴ�. ���� ��ȸ�� �̿����ּ���.");
		
	}

	@Override
	public void ejectQuater() {
		System.out.println("������ ���� �����̽��ϴ�. ������ ��ȯ���� �ʽ��ϴ�.");
	}

	@Override
	public void turnCrank() {
		System.out.println("�����Ǿ����ϴ�.");
		
	}

	@Override
	public void dispense() {
		System.out.println("�����Դϴ�.");
	}
}

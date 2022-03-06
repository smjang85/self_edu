package design_pattern_edu.proxy_pattern;

import design_pattern_edu.proxy_pattern.model.GumballMachine;

public class GumballMonitor {
	GumballMachine machine;
	
	public GumballMonitor(GumballMachine machine) {
		this.machine = machine;
	}
	
	public void report() {
		System.out.println("�̱� ��� ��ġ :" + machine.getLocation());
		System.out.println("���� ��� : " + machine.getCount() + " ��");
		System.out.println("���� ���� : " + machine.getState());
	}
}

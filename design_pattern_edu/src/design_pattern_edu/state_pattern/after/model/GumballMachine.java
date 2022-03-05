package design_pattern_edu.state_pattern.after.model;

import design_pattern_edu.state_pattern.after.state.State;
import design_pattern_edu.state_pattern.after.state.impl.HasQuaterState;
import design_pattern_edu.state_pattern.after.state.impl.NoQuaterState;
import design_pattern_edu.state_pattern.after.state.impl.SoldOutState;
import design_pattern_edu.state_pattern.after.state.impl.SoldState;
import design_pattern_edu.state_pattern.after.state.impl.WinnerState;

/*
 * 9 ������Ʈ ����(State Pattern)
 * ��ü�� ���� ���°� �ٲ� ���� ��ü�� �ൿ�� �ٲ� �� �ֽ��ϴ�. ��ġ ��ü�� Ŭ������ �ٲ�� �Ͱ� ���� ����� ���� �� �ֽ��ϴ�.
 * 
 * �Ϲ������� ��Ʈ��Ƽ�� ������ ����Ŭ������ ����� ����� ����Ͽ� �������� �ش�ȭ�ϱ� ���� �뵵�� ���Դϴ�. ����� �̿��ؼ� Ŭ������ �ൿ��
 * �����ϴ� ���� �ൿ�� �����ؾ� �� �� ������� �����ϱ� ������. ������ ��Ʈ��Ƽ�� ������ ����ϸ� ������ ���� �ൿ�� �����ϴ� ��ü�� �����ϰ� �ٲ� �� �ֽ��ϴ�.
 * 
 * ������Ʈ ������ ���ؽ�Ʈ ��ü�� ������ ���ǹ��� ����ִ� ��ſ� ��� �� �� �ִ� ����. �ൿ�� ���� ��ü ���� ĸ��ȭ��Ű�� ���ؽ�Ʈ ���� ���� ��ü�� �ٲٴ� �͸����ε� ���ؽ�Ʈ ��ü�� �ൿ��
 * �ٲ� �� ����.
 * 
 * ### ���ο� ������ ��ȹ ###
 * �켱 �̱� ���� ���õ� ��� �ൿ�� ���� �޼ҵ尡 ����ִ� State �������̽��� ����
 * 
 * �� �������� ����� ��� ���¿� ���ؼ� ���� Ŭ������ �����ؾ� �մϴ�. ��谡 � ���¿� �ִٸ�, �� ���¿� �ش��ϴ� ���� Ŭ������ ��� �۾��� å������ ��
 * 
 * ���������� ���ǹ� �ڵ带 ���� ���ְ� ���� Ŭ������ ��� �۾��� �����մϴ�.
 * 
 * ### ���ݱ��� ����
 * 
 * -> �� ������ �ൿ�� ������ Ŭ������ ����ȭ��Ŵ
 * -> �����ϱ� ���� ��ĩ��� if ���𹮵��� ������
 * -> �� ���¸� ���濡 ���ؼ��� ���� �ֵ��� �ϸ鼭�� GumballMachine ��ü�� ���ο� ���� Ŭ������ �߰��ϴ� Ȯ�忡 ���ؼ� ���� �ֵ��� ������ (OCP)
 * -> ó���� �ֽ�ȸ�� �ջ̱⿡�� �����ߴ� ���̾�׷��� �ν� �����鼭 �� �����ϱ� ���� �ڵ� ���̽��� Ŭ���� ������ �������
 */
public class GumballMachine {
	
	State soldOutState;
	State noQuaterState;
	State hasQuarterState;
	State soldState;
	State winnerState; // �߰�

	State state = soldState;
	int count = 0;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuaterState = new NoQuaterState(this);
		hasQuarterState = new HasQuaterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		this.count = numberGumballs;
		if(numberGumballs > 0) {
			state = noQuaterState;
		}
	}
	
	public void insertQuater() {
		state.insertQuater();
	}
	
	public void ejectQuarter() {
		state.ejectQuater();
	}
	
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	
	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if(count != 0) {
			count = count -1;
		}
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(State soldOutState) {
		this.soldOutState = soldOutState;
	}

	public State getNoQuaterState() {
		return noQuaterState;
	}

	public void setNoQuaterState(State noQuaterState) {
		this.noQuaterState = noQuaterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(State hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public void setSoldState(State soldState) {
		this.soldState = soldState;
	}
	
	public State getWinnerState() {
		return winnerState;
	}

	public void setWinnerState(State winnerState) {
		this.winnerState = winnerState;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public String toString() {
		String result = "\n##### �ֽ�ȸ�� �ջ̱� #####\n" + "�ڹٷ� ����� 2004���� �̱� ���\n" + "���� ���� :" + count +"��\n" +"���� ���� �����\n";
		return result;
	}
}

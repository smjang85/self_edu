package design_pattern_edu.proxy_pattern.model;

import design_pattern_edu.proxy_pattern.state.State;
import design_pattern_edu.proxy_pattern.state.impl.HasQuaterState;
import design_pattern_edu.proxy_pattern.state.impl.NoQuaterState;
import design_pattern_edu.proxy_pattern.state.impl.SoldOutState;
import design_pattern_edu.proxy_pattern.state.impl.SoldState;
import design_pattern_edu.proxy_pattern.state.impl.WinnerState;

/*
 * 10.프록시 패턴
 */
public class GumballMachine {
	
	State soldOutState;
	State noQuaterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	String location;

	State state = soldState;
	int count = 0;

	public GumballMachine(String location, int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuaterState = new NoQuaterState(this);
		hasQuarterState = new HasQuaterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		this.count = numberGumballs;
		if(numberGumballs > 0) {
			state = noQuaterState;
		}
		
		this.location = location;
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
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		String result = "\n##### 주식회사 왕뽑기 #####\n" + "자바로 돌어가는 2004년형 뽑기 기계\n" + "남은 개수 :" + count +"개\n" +"동전 투입 대기중\n";
		return result;
	}
}

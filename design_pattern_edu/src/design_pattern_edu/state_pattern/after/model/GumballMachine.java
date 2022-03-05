package design_pattern_edu.state_pattern.after.model;

import design_pattern_edu.state_pattern.after.state.State;
import design_pattern_edu.state_pattern.after.state.impl.HasQuaterState;
import design_pattern_edu.state_pattern.after.state.impl.NoQuaterState;
import design_pattern_edu.state_pattern.after.state.impl.SoldOutState;
import design_pattern_edu.state_pattern.after.state.impl.SoldState;
import design_pattern_edu.state_pattern.after.state.impl.WinnerState;

/*
 * 9 스테이트 패턴(State Pattern)
 * 객체의 내부 상태가 바뀜에 따라서 객체의 행동을 바꿀 수 있습니다. 마치 객체의 클래스가 바뀌는 것과 같은 결과를 얻을 수 있습니다.
 * 
 * 일반적으로 스트래티지 패턴은 서브클래스를 만드는 방법을 대신하여 유연성을 극대화하기 위한 용도로 쓰입니다. 상속을 이용해서 클래서의 행동을
 * 정의하다 보면 행동을 변경해야 할 때 마음대로 변경하기 힘들죠. 하지만 스트래티지 패턴을 사용하면 구성을 통해 행동을 정의하는 객체를 유연하게 바꿀 수 있습니다.
 * 
 * 스테이트 패턴은 컨텍스트 객체에 수많은 조건문을 집어넣는 대신에 사용 할 수 있는 패턴. 행동을 상태 객체 내에 캡슐화시키면 컨텍스트 내의 상태 객체를 바꾸는 것만으로도 컨텍스트 객체의 행동을
 * 바꿀 수 있음.
 * 
 * ### 새로운 디자인 계획 ###
 * 우선 뽑기 기계와 관련된 모든 행동에 대한 메소드가 들어있는 State 인터페이스를 정의
 * 
 * 그 다음에는 기계의 모든 상태에 대해서 상태 클래스를 구현해야 합니다. 기계가 어떤 상태에 있다면, 그 상태에 해당하는 상태 클래스가 모든 작업을 책임져야 됨
 * 
 * 마지막으로 조건문 코드를 전부 없애고 상태 클래스에 모든 작업을 위임합니다.
 * 
 * ### 지금까지 한일
 * 
 * -> 각 상태의 행동을 별개의 클래스로 국지화시킴
 * -> 관리하기 힘든 골칫덩어리 if 선언문들을 없앴음
 * -> 각 상태를 변경에 대해서는 닫혀 있도록 하면서도 GumballMachine 자체는 새로운 상태 클래스를 추가하는 확장에 대해서 열려 있도록 고쳤음 (OCP)
 * -> 처음에 주식회사 왕뽑기에서 제시했던 다이어그램에 훨신 가까우면서 더 이해하기 좋은 코드 베이스와 클래스 구조를 만들었음
 */
public class GumballMachine {
	
	State soldOutState;
	State noQuaterState;
	State hasQuarterState;
	State soldState;
	State winnerState; // 추가

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
		String result = "\n##### 주식회사 왕뽑기 #####\n" + "자바로 돌어가는 2004년형 뽑기 기계\n" + "남은 개수 :" + count +"개\n" +"동전 투입 대기중\n";
		return result;
	}
}

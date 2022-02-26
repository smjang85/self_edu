package design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.impl;

import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Duck;
import design_pattern_edu.adaptor_facade_pattern.adapter_pattern.animal.Turkey;

public class TurkeyAdapter implements Duck{
	Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		for(int i = 0; i < 5 ; i++) {
			turkey.fly();
		}
	}
}

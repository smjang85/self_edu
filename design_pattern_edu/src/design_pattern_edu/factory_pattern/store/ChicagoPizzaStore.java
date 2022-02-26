package design_pattern_edu.factory_pattern.store;

import design_pattern_edu.factory_pattern.pizza.Pizza;
import design_pattern_edu.factory_pattern.pizza.chicagostyle.ChicagoStyleCheesePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String item) {
		if(item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else return null;
	}

}

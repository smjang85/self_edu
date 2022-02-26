package design_pattern_edu.factory_pattern.store;

import design_pattern_edu.factory_pattern.ingredient_factory.PizzaIngredientFactory;
import design_pattern_edu.factory_pattern.ingredient_factory.impl.NYPizzaIngredientFactory;
import design_pattern_edu.factory_pattern.pizza.Pizza;
import design_pattern_edu.factory_pattern.pizza.origin.CheesePizza;
import design_pattern_edu.factory_pattern.pizza.origin.ClamPizza;
import design_pattern_edu.factory_pattern.pizza.origin.PepperoniPizza;
import design_pattern_edu.factory_pattern.pizza.origin.VeggiePizza;

public class NYPizzaStore extends PizzaStore {
	@Override
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
		
		if(item.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		} else if(item.equals("veggie")) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
		} else if(item.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
		} else if(item.equals("pepperoni")) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
		} 
		
		return pizza;
	}

}

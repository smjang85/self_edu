package design_pattern_edu.factory_pattern.ingredient_factory;

import design_pattern_edu.factory_pattern.ingredient.origin.Cheese;
import design_pattern_edu.factory_pattern.ingredient.origin.Clams;
import design_pattern_edu.factory_pattern.ingredient.origin.Dough;
import design_pattern_edu.factory_pattern.ingredient.origin.Pepperoni;
import design_pattern_edu.factory_pattern.ingredient.origin.Sauce;
import design_pattern_edu.factory_pattern.ingredient.origin.Veggies;

public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}

package design_pattern_edu.factory_pattern.ingredient_factory.impl;

import design_pattern_edu.factory_pattern.ingredient.nystyle.FreshClams;
import design_pattern_edu.factory_pattern.ingredient.nystyle.MarinaraSauce;
import design_pattern_edu.factory_pattern.ingredient.nystyle.ReggianoCheese;
import design_pattern_edu.factory_pattern.ingredient.nystyle.SlicedPepperoni;
import design_pattern_edu.factory_pattern.ingredient.nystyle.ThinCrustDough;
import design_pattern_edu.factory_pattern.ingredient.nystyle.veggies.Garlic;
import design_pattern_edu.factory_pattern.ingredient.nystyle.veggies.Mushroom;
import design_pattern_edu.factory_pattern.ingredient.nystyle.veggies.Onion;
import design_pattern_edu.factory_pattern.ingredient.nystyle.veggies.RedPepper;
import design_pattern_edu.factory_pattern.ingredient.origin.Cheese;
import design_pattern_edu.factory_pattern.ingredient.origin.Clams;
import design_pattern_edu.factory_pattern.ingredient.origin.Dough;
import design_pattern_edu.factory_pattern.ingredient.origin.Pepperoni;
import design_pattern_edu.factory_pattern.ingredient.origin.Sauce;
import design_pattern_edu.factory_pattern.ingredient.origin.Veggies;
import design_pattern_edu.factory_pattern.ingredient_factory.PizzaIngredientFactory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies[] veggies = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}

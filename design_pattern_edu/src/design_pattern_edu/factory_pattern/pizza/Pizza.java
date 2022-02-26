package design_pattern_edu.factory_pattern.pizza;

import design_pattern_edu.factory_pattern.ingredient.origin.Cheese;
import design_pattern_edu.factory_pattern.ingredient.origin.Clams;
import design_pattern_edu.factory_pattern.ingredient.origin.Dough;
import design_pattern_edu.factory_pattern.ingredient.origin.Pepperoni;
import design_pattern_edu.factory_pattern.ingredient.origin.Sauce;
import design_pattern_edu.factory_pattern.ingredient.origin.Veggies;

public abstract class Pizza {
	public String name;
	public Dough dough;
	public Sauce sauce;
	public Veggies veggies[];
	public Cheese cheese;
	public Pepperoni pepperoni;
	public Clams clam;
	
//	ArrayList toppings = new ArrayList();
/*	
	public void prepare() {
		System.out.println("preparing " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings : ");
		for(int i = 0 ; i < toppings.size(); i++) {
			System.out.println("  " + toppings.get(i));
		}
	}
*/	
	public abstract void prepare();
	
	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
	
	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
	
	public void box() {
		System.out.println("Place pizza in ofiicial PizzaStore box");
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		System.out.println("This Pizza name is " + name);
		return name;
	}
}

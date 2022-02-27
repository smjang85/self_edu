package design_pattern_edu.template_method_pattern.sort;

public class Duck implements Comparable {
	String name;
	int weight;
	
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
		return name + ", Ã¼Áß:" + weight;
	}
	
	public int compareTo(Object object) {
		Duck otherDuck = (Duck) object;
		
		if(this.weight < otherDuck.weight) {
			return -1;
		} else if (this.weight == otherDuck.weight) {
			return 0;
		} else {
			return 1;
		}
	}

}

package chap08.after.user_point.model;

public class Product {
	int defaultPoint;
	
	public Product() {
		this.defaultPoint = 100;
	}
	
	public void setDefaultPoint(int defaultPoint) {
		this.defaultPoint = defaultPoint;
	}
	
	public int getDefaultPoint() {
		return defaultPoint;
	}
}

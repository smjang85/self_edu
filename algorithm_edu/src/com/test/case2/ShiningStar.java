package com.test.case2;
import org.junit.Assert;

public class ShiningStar {
	String name;
	boolean checkCall = false;
	double shineFactor;
	
    // Write the code here
    public ShiningStar(double shineFactor){
    	this.shineFactor = shineFactor;
    }
    
    public static void main(String[] args) {
    	double shineFactor = 1.5d;
    	ShiningStar star = new ShiningStar(shineFactor);
    	star.fadeOut();
    	star.shine();
        
    }
    
    public void fadeOut(){
    	if(this.getCheckCall() == false) {
    		throw new IllegalStateException();
    	}
    	checkCall = false;
    }
    
    public double shine(){
    	checkCall = true;
        return shineFactor;
    }
    public boolean getCheckCall() {
		return checkCall;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
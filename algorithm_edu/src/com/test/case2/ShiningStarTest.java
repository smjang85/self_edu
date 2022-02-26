package com.test.case2;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ShiningStarTest {

	@Test
	public void NewStarsCanShine() {
		double shineFactor = 1d;
    	ShiningStar star = new ShiningStar(shineFactor);
    	Assert.assertEquals(shineFactor, star.shine(),0.0d);
	}
	
	@Test(expected = IllegalStateException.class)
	public void FadedOutStarscannotShine() {
		double shineFactor = 1.5d;
    	ShiningStar star = new ShiningStar(shineFactor);
    	star.fadeOut();
    	star.shine();
	}

}

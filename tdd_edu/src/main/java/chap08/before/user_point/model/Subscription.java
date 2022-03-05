package chap08.before.user_point.model;

import java.time.LocalDate;

import chap08.before.user_point.Grade;

public class Subscription {
	private String productId;
	private boolean finished;
	private Grade grade;
	
	public Subscription() {
		this.finished = false;
		this.grade = Grade.GOLD;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public boolean isFinished(LocalDate now) {
		return finished;
	}
	
	public Grade getGrade() {
		return grade;
	}
}

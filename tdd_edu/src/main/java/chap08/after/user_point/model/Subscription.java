package chap08.after.user_point.model;

import java.time.LocalDate;

import chap08.after.user_point.Grade;

public class Subscription {
	private String productId;
	private boolean finished;
	private Grade grade;
	LocalDate date;
	
	public Subscription() {
		this.finished = false;
		this.grade = Grade.GOLD;
	}
	
	public Subscription(LocalDate date, Grade grade) {
		this.date = date;
		this.grade = grade;
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

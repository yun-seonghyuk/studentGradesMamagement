package com.green.dto;

public class StudentScoreDto {
	private int kor;
	private int eng;
	private int math;
	private int science;
	private int social;
	private int total;
	private double avg;
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getScience() {
		return science;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int kor, int math , int eng, int social, int science) {
		this.total = kor+ eng + math + social + science;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(int total) {
		this.avg = this.total/5.0;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getSocial() {
		return social;
	}
	public void setSocial(int social) {
		this.social = social;
	} 
	
	
	
	
}

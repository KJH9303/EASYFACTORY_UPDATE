package com.feb.vo;

public class FebIndexVO {

	String Process_Feb;
	int Month;
	int Difficulty;
	int Realtime_Difficulty;
	int Elec_using;
	int Production;
	int InDex_Cost;

	public FebIndexVO(
			String process_Feb, 
			int month, 
			int difficulty, 
			int realtime_Difficulty, 
			int elec_using,
			int production, int inDex_Cost) {
		this.Process_Feb = process_Feb;
		this.Month = month;
		this.Difficulty = difficulty;
		this.Realtime_Difficulty = realtime_Difficulty;
		this.Elec_using = elec_using;
		this.Production = production;
		this.InDex_Cost = inDex_Cost;
	}
	
	public FebIndexVO() {
	}

	@Override
	public String toString() {
		return "FebIndexVO [Process_Feb=" + Process_Feb + ", Month=" + Month + ", Difficulty=" + Difficulty
				+ ", Realtime_Difficulty=" + Realtime_Difficulty + ", Elec_using=" + Elec_using + ", Production="
				+ Production + ", InDex_Cost=" + InDex_Cost + "]";
	}
	
	public String getProcess_Feb() {
		return Process_Feb;
	}
	public void setProcess_Feb(String process_Feb) {
		Process_Feb = process_Feb;
	}
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public int getDifficulty() {
		return Difficulty;
	}
	public void setDifficulty(int difficulty) {
		Difficulty = difficulty;
	}
	public int getRealtime_Difficulty() {
		return Realtime_Difficulty;
	}
	public void setRealtime_Difficulty(int realtime_Difficulty) {
		Realtime_Difficulty = realtime_Difficulty;
	}
	public int getElec_using() {
		return Elec_using;
	}
	public void setElec_using(int elec_using) {
		Elec_using = elec_using;
	}
	public int getProduction() {
		return Production;
	}
	public void setProduction(int production) {
		Production = production;
	}
	public int getInDex_Cost() {
		return InDex_Cost;
	}
	public void setInDex_Cost(int inDex_Cost) {
		InDex_Cost = inDex_Cost;
	}
}

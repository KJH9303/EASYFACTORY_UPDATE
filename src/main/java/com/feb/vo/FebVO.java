package com.feb.vo;

import java.util.Date;

public class FebVO {
	private double opratio;
	private int temp;
	private int tr;
	private int fal;
	private int stock;
	private int costs;
	private double usingratio;
	private Date hiredate;
	
	public FebVO() {
	}
	
	   public FebVO(
			   double opratio
			   , int temp
			   , int tr
			   , int fal
			   , int stock
			   , int costs
			   , double usingratio
			   , Date hiredate) {
	      this.opratio = opratio;
	      this.temp = temp;
	      this.tr = tr;
	      this.fal = fal;
	      this.stock = stock;
	      this.costs = costs;
	      this.usingratio = usingratio;
	      this.hiredate = hiredate;
	   }
	   
	@Override
	   public String toString() {
	      String msg = String.format("process [opratio=" + opratio + ", temp=" + temp + ", tr=" + tr + ", fal=" + fal + ", stock=" + stock + ", costs=" + costs
	            + ", usingratio=" + usingratio + ", hiredate=" + hiredate + "]");
	      return msg;
	   }

	   public double getOpratio() {
	      return opratio;
	   }
	   public void setOpratio(double opratio) {
	      this.opratio = opratio;
	   }
	   public int getTemp() {
	      return temp;
	   }
	   public void setTemp(int temp) {
	      this.temp = temp;
	   }
	   public int getTr() {
	      return tr;
	   }
	   public void setTr(int tr) {
	      this.tr = tr;
	   }
	   public int getFal() {
	      return fal;
	   }
	   public void setFal(int fal) {
	      this.fal = fal;
	   }
	   public int getStock() {
	      return stock;
	   }
	   public void setStock(int stock) {
	      this.stock = stock;
	   }
	   public int getCosts() {
	      return costs;
	   }
	   public void setCosts(int costs) {
	      this.costs = costs;
	   }
	   public double getUsingratio() {
	      return usingratio;
	   }
	   public void setUsingratio(double usingratio) {
	      this.usingratio = usingratio;
	   }
	   public Date getHiredate() {
	      return hiredate;
	   }
	   public void setHiredate(Date hiredate) {
	      this.hiredate = hiredate;
	   }

	}
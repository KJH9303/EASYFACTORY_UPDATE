package com.feb.service;

import org.json.simple.JSONArray;

import com.feb.dao.FebDAO;

public class FebService {
	
	private FebDAO febDAO;

	public FebService(FebDAO febDAO) {
		this.febDAO = febDAO;
	}
	/*
	public JSONArray selectData() {
        return febDAO.selectData();
    }
	*/
	public JSONArray selectDataHiredate(String tableName, String startDate, String endDate) {
        return febDAO.selectDataHiredate(tableName, startDate, endDate);
    }
	
	public void updateTables() {
		febDAO.insertTable("feb1");
		febDAO.insertTable("feb2");
		febDAO.insertTable("feb3");
		febDAO.insertTable("feb4");
		febDAO.insertTable("feb5");
		febDAO.insertTable("feb6");
		febDAO.insertTable("feb7");
		febDAO.insertTable("feb8");
		
		System.out.println("FebService : updateTables 찍힘");
	}
	
	public void startUpdateFeb(String run) {
		System.out.println("■■■■■■■■■■ startUpdateFeb. ■■■■■■■■■■");
        while (run.equals("run")) {
        	febDAO.updateTable("feb1");
        	febDAO.updateTable("feb2");
        	febDAO.updateTable("feb3");
        	febDAO.updateTable("feb4");
        	febDAO.updateTable("feb5");
        	febDAO.updateTable("feb6");
        	febDAO.updateTable("feb7");
        	febDAO.updateTable("feb8");
	
	        System.out.println("■■■■■■■■■■ 모든 공정의 데이터 UPDATE작업이 완료되었습니다. ■■■■■■■■■■");
	        
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
        }
    }
        
    public String getRandomDefect() throws Exception {
		String result = febDAO.getRandomDefect();
		return result;
	}

}
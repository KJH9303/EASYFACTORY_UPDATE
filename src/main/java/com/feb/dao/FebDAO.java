package com.feb.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Random;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FebDAO {
	
    public Object updateTable;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	FebIndexDAO febIndexDAO;

    public FebDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // insertDAO
 	public void insertTable(String tableName) {
        Random random = new Random();

        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
        for (int i = 0; i < 365; i++) {
            double opratio = Math.round((70 + random.nextDouble() * (100 - 70)) * 100.0) / 100.0;
            int temp = random.nextInt(15) + 1;
            int tr = random.nextInt(10000) + 1;
            int fal = random.nextInt(100) + 1;
            int stock = random.nextInt(1000) + 1;
            int costs = random.nextInt(1000) + 1;
            double usingratio = Math.round(random.nextDouble() * 100 * 100.0) / 100.0;

            temp = Math.max(0, Math.min(15, temp));

            LocalDateTime currentDateTime = dateTime.plusDays(i);
            java.sql.Date currentDate = java.sql.Date.valueOf(currentDateTime.toLocalDate());

            try {
                String SQL = "INSERT INTO " + tableName + " (opratio, temp, tr, fal, stock, costs, usingratio, hiredate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                int result = jdbcTemplate.update(SQL, opratio, temp, tr, fal, stock, costs, usingratio, currentDate);
                
                System.out.println("[" + tableName.toUpperCase() + " 테이블의 INSERT 작업이 완료되었습니다.]");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(">>> 날짜 " + currentDate + " INSERT 작업 중 예외가 발생하였습니다: " + e.getMessage());
            }
        }
    }
 	
 	/*
 	 * 공정테이블 : 일별처리
 	 *  칼럼: 장비가동율, 온도, 정품수량, 불량수량, 재고, 비용
 	 */
    public void updateTable(String tableName) {
        Random random = new Random();

        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 1, 0, 0, 0);
        for (int i = 0; i < 365; i++) {

            int temp = random.nextInt(15) + 1; 			// 온도
            temp = Math.max(0, Math.min(15, temp));
            double stock;
            
            // 공정별 전기사용량 기준치  + 전기사용량
            double randomUsingratio = Math.round(random.nextDouble() * 20 * 20.0) / 20.0;
            double usingRatio = febIndexDAO.selectFebIndex_Elec_VO(tableName) + ((randomUsingratio > 10.0) ? randomUsingratio - 10.0 : -randomUsingratio);  
            
            // 공정별 연평균 전기비용 기준치 + 전기사용량
            double costs = (febIndexDAO.selectFebIndex_Cost_VO(tableName) * (usingRatio)); 
            
            // 공정별 생산량 대비 장비가동률(0부터 20까지의 수 중에 랜덤값 생성)
            double randomOpratio = Math.round(random.nextDouble() * 20 * 20.0) / 20.0;
            double opratio = febIndexDAO.selectFebIndex_production_VO(tableName) + ((randomOpratio > 10.0) ? randomOpratio - 10.0 : -randomOpratio);
            
            // 공정별 난이도대비 불량품 (0부터 20까지의 수 중에 랜덤값 생성)
            double randomFal = Math.round(random.nextDouble() * 20 * 20.0) / 20.0;
            double fal = febIndexDAO.selectFebindex_view_Difficulty(tableName) * (100) + ((randomFal > 10.0) ? randomFal - 10.0 : -randomFal);
            
            // 공정별 전기사용량 기준치 + 생산량
            double randomTr = Math.round(random.nextDouble() * 20 * 20.0) / 20.0;
            double tr = febIndexDAO.selectFebIndex_Elec_VO(tableName) * (1000) + ((randomTr > 10.0) ? randomTr - 1000.0 : -randomTr);

            stock = (double)tr - (double)fal;	// 재고
            
            LocalDateTime currentDateTime = dateTime.plusDays(i);
            java.sql.Date currentDate = java.sql.Date.valueOf(currentDateTime.toLocalDate());

            try {
                String SQL = "UPDATE " + tableName + " SET opratio = ?, temp = ?, tr = ?, fal = ?, stock = ?, costs = ?, usingratio = ? WHERE hiredate = ?";
                int result = jdbcTemplate.update(SQL, opratio, temp, tr, fal, stock, costs, usingRatio, currentDate);

                System.out.println("[" + tableName.toUpperCase() + " 테이블의 업데이트 작업이 완료되었습니다.]");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(">>> 날짜 " + currentDate + " 업데이트 작업 중 예외가 발생하였습니다: " + e.getMessage());
            }
        }
    }

    // 랜덤불량생성
	public static String getRandomDefect() {
		while (true) {
		    LocalDate nowdate = LocalDate.now();
		    LocalTime nowtime = LocalTime.now();
	
		    int num = (int)(Math.random()*8) +1;
		    String result = "";
		    
		    if (num == 1) {
		        result = "Wafer 결함 발생.　　" + " " + nowdate + " " + nowtime;
		    } else if (num == 2) {
		        result = "Pattern  손상.　　　" + " " + nowdate + " " + nowtime;
		    } else if (num == 3) {
		        result = "공정 무너짐.　　　　" + " " + nowdate + " " + nowtime;
		    } else if (num == 4) {
		        result = "particle 불량.　　　" + " " + nowdate + " " + nowtime;
		    } else if (num == 5) {
		        result = "Crack  발생.　　　　" + " " + nowdate + " " + nowtime;
		    } else if (num == 6) {
		        result = "Parameter  뒤틀림.　" + " " + nowdate + " " + nowtime;    
		    } else {
		        result = "공정불량.　　　　　" + " "  + nowdate + " " + nowtime;
		    }
		    System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●● Defect 작동 ●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
		    System.out.println("●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●Random defect: " + result); 
		    
		    return result;
		}
	}
}

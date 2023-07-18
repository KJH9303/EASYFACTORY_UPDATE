package com.feb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.easyfactory.config.AppCtx;
import com.feb.dao.FebDAO;

public class InsertMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
    	
        FebDAO febDAO = ctx.getBean(FebDAO.class);

        // 테이블 업데이트 실행
        febDAO.insertTable("feb1");
        febDAO.insertTable("feb2");
        febDAO.insertTable("feb3");
        febDAO.insertTable("feb4");
        febDAO.insertTable("feb5");
        febDAO.insertTable("feb6");
        febDAO.insertTable("feb7");
        febDAO.insertTable("feb8");

        System.out.println("■■■■■■■■■■모든 공정의 데이터 INSERT작업이 완료되었습니다.■■■■■■■■■■");
    }
}


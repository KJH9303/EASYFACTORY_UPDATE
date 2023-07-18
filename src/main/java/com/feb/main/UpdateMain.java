package com.feb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.easyfactory.config.AppCtx;
import com.feb.dao.FebDAO;

public class UpdateMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        FebDAO febDAO = ctx.getBean(FebDAO.class);

        while (true) {
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
}



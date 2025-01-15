package com.example.kiosk5;

import java.util.Scanner;

public class Kiosk {

    public static void start(Menu menu) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String selectCategory="";
            String selectMenu="";
            String state="";


            // 카테고리 선택 영역
            while (true){
                state="";
                menu.PrintCategory();
                selectCategory = sc.next();
                // Verify.handlingExit 매서드에서 String selectCategory 값을 검증
                try {
                    Verify.handlingExit(selectCategory, menu);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (Exception e) {
                    state = StateType.EXIT.getState();
                    System.out.println(e.getMessage());
                }
                break;
            }
            // 메뉴선택에서 0을 선택했다면, 프로그램 종료
            if ( StateType.act(state) ) {
                break;
            }


            // 메뉴 선택 영역
            while (true) {
                state="";
                menu.PrintSelectedCategory(selectCategory);
                selectMenu = sc.next();
                // Verify.handlingGoBack 매서드에서 String selectMenu 값을 검증
                try {
                    Verify.handlingGoBack(selectCategory,selectMenu,menu);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e ) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (Exception e) {
                    state = StateType.GOBACK.getState();
                    System.out.println(e.getMessage());
                }
                break;
            }
            // 메뉴선택에서 0을 선택했다면, 프로그램 재시작
            if ( StateType.act(state) ) {
                continue;
            }


            // 선택한 메뉴 출력
            menu.PrintSelectedMenu(selectCategory, selectMenu);

        }
        sc.close();
    }
}

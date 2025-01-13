package com.example.kiosk1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            // MenuItem 클래스의 인스턴스 생성, 메뉴 출력
            MenuItem menuItem = new MenuItem();
            System.out.println("\n[ SHAKESHACK MENU ]");
            menuItem.getMenuPrintAll();
            System.out.println("0. 종료           | 종료 ");
            String input = sc.next();

            // Verify.handling 매서드에서 String input 값을 검증
            try{
                Verify.handling(input);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
                continue;
            } catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }

            // 검증된 String input을 parseInt 하여, 해당 메뉴 출력
            int selectNumber = Integer.parseInt(input)-1;
            System.out.println("\n선택된 메뉴 = "+menuItem.getMenuSelect(selectNumber));

        }

    }

}




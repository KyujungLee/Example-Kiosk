package com.example.kiosk2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public static void Action() {

        Scanner sc = new Scanner(System.in);

        // 공유 인스턴스 생성 및 해당 인스턴스에 메뉴 저장.
        MenuItem menuItem = MenuItem.menuItem();
        menuItem.setMenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItem.setMenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuItem.setMenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItem.setMenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거");


        while(true){

            // MenuItem 클래스의 인스턴스 생성, 메뉴 출력

            System.out.println("\n[ SHAKESHACK MENU ]");
            menuItem.getMenuPrintAll();
            System.out.println("0. 종료");
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
            List<String> menu = menuItem.getMenuSelect(selectNumber);
            System.out.println("\n선택된 메뉴 = "+ input +". "+menu.get(0)+", "+menu.get(1)+", "+menu.get(2));

        }

        sc.close();

    }
}

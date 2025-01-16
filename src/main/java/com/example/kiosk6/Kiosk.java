package com.example.kiosk6;

import java.util.Scanner;

public class Kiosk {
    public static void start(Menu menu, ShoppingBag shoppingBag){
        Scanner sc = new Scanner(System.in);
        String state;
        String input;
        while (true){

            // 카테고리 선택 입출력 부분
            if(shoppingBag.getShoppingBag().isEmpty()){
                menu.printCategory();
                input = sc.next();
                state = Verify.categoryCheck(input, menu);
                if ( StateType.CONTINUE.getState().equals(state) ){
                    continue;
                } else if ( StateType.BREAK.getState().equals(state)) {
                    break;
                }
            } else {
                menu.printCategory();
                shoppingBag.printSelectOrder();
                input = sc.next();
                state = Verify.orderCheck(input, menu, shoppingBag);
                if ( StateType.CONTINUE.getState().equals(state) ){
                    continue;
                } else if ( StateType.BREAK.getState().equals(state)) {
                    break;
                }
                while (true){
                    input = sc.next();
                    state = Verify.tryOrderCheck(input, shoppingBag);
                    if ( StateType.CONTINUE.getState().equals(state) ){
                        continue;
                    } else if ( StateType.BREAK.getState().equals(state)) {
                        break;
                    }
                }
                if (StateType.BREAK.getState().equals(state)){
                    continue;
                }
            }

            while (true){

                // 메뉴 선택 입출력 부분
                menu.printMenu(input);
                input = sc.next();
                state = Verify.menuCheck(input, menu);
                if ( StateType.CONTINUE.getState().equals(state) ){
                    continue;
                } else if ( StateType.BREAK.getState().equals(state)) {
                    break;
                }

                while (true){

                    // 장바구니 선택 입출력 부분
                    menu.printSelectedItem(input);
                    shoppingBag.printAskAddItem();
                    input = sc.next();
                    state = Verify.addItemCheck(input,menu,shoppingBag);
                    if ( StateType.CONTINUE.getState().equals(state) ){
                        continue;
                    } else if ( StateType.BREAK.getState().equals(state)) {
                        break;
                    }
                }
            }
        }
    }
}

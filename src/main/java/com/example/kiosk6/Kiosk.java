package com.example.kiosk6;

import java.util.Scanner;

public class Kiosk {
    public static void start(Menu menu, ShoppingBag shoppingBag){

        // stage 변수를 이용하여, 반복문의 조건을 통한 스테이지의 동작권한 결정
        Scanner sc = new Scanner(System.in);
        StageType stage = StageType.STAGE1_CHOOSE_MENU;
        String input;

        // 키오스크 로직
        while ( stage != StageType.EXIT ){

            // STAGE1 카테고리 선택 입출력 부분
            while ( stage == StageType.STAGE1_CHOOSE_MENU ) {
                menu.printChooseMenu();
                input = sc.next();
                stage = DetermineStage.stage1Check(input, menu);
                // 검증된 입력값으로 선택된 메뉴를 저장
                if ( stage == StageType.STAGE2_CHOOSE_ITEM ){
                    menu.setSelectedMenu(input);
                }

                // STAGE2 메뉴 선택 입출력 부분
                while ( stage == StageType.STAGE2_CHOOSE_ITEM ) {
                    menu.printChooseItem();
                    input = sc.next();
                    stage = DetermineStage.stage2Check(input, menu);
                    // 검증된 입력값으로 선택된 아이템 저장
                    // 뒤로가기 입력 시 선택된 아이템 제거
                    if ( stage == StageType.STAGE3_ADD_SHOPPINGBAG ){
                        menu.setSelectedItem(input);
                    }

                    // STAGE3 장바구니 추가 입출력 부분
                    while ( stage == StageType.STAGE3_ADD_SHOPPINGBAG ) {
                        menu.printSelectedItem();
                        shoppingBag.printChooseAddItem();
                        input = sc.next();
                        stage = DetermineStage.stage3Check(input, menu, shoppingBag);
                        // 장바구니 추가 선택 시 동작
                        if ( stage == StageType.STAGE4_CHOOSE_MENU_PAYMENT ){
                            shoppingBag.printAddItem(menu);
                        }

                        // STAGE4 카테고리 선택 or 결제 선택 입출력 부분
                        while (stage == StageType.STAGE4_CHOOSE_MENU_PAYMENT ) {
                            menu.printChooseMenu();
                            shoppingBag.printChoosePayment(menu);
                            input = sc.next();
                            stage = DetermineStage.stage4Check(input, menu, shoppingBag);

                            // STAGE5 장바구니 결제 입출력 부분
                            while ( stage == StageType.STAGE5_PROCEED_PAYMENT ) {
                                shoppingBag.printProceedPayment();
                                input = sc.next();
                                stage = DetermineStage.stage5Check(input);

                                // STAGE6 할인 입출력 부분
                                while ( stage == StageType.STAGE6_CHOOSE_DISCOUNT ){
                                    shoppingBag.printChooseDiscount();
                                    input = sc.next();
                                    stage = DetermineStage.stage6Check(input);
                                    // 검증된 입력값으로 선택된 할인 적용
                                    if ( stage == StageType.STAGE1_CHOOSE_MENU ){
                                        shoppingBag.printCompletePayment(input);
                                    }
                                }

                            }

                        }

                    }

                }

            }

        }
    }
}

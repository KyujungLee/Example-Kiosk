package com.example.kiosk6;

import java.util.Scanner;

public class Kiosk {
    public static void start(Menu menu, ShoppingBag shoppingBag){

        // stage 변수를 이용하여, 반복문의 조건을 통한 스테이지의 동작권한 결정
        Scanner sc = new Scanner(System.in);
        StageType stage = StageType.STAGE1;
        String input;

        // 키오스크 로직
        while ( stage != StageType.EXIT ){

            // STAGE1 카테고리 선택 입출력 부분
            while ( stage == StageType.STAGE1 || stage == StageType.STAGE1_RELOAD ) {
                menu.printCategory();
                input = sc.next();
                stage = DetermineStage.stage1Check(input, menu);

                // STAGE2 메뉴 선택 입출력 부분
                while ( stage == StageType.STAGE2 || stage == StageType.STAGE2_RELOAD ) {
                    // STAGE1 에서 선택한 카테고리를 유지하기 위해 조건문 처리
                    if ( stage == StageType.STAGE2 ){
                        menu.printMenu(input);
                    }
                    input = sc.next();
                    stage = DetermineStage.stage2Check(input, menu);

                    // STAGE3 장바구니 추가 입출력 부분
                    while ( stage == StageType.STAGE3 || stage == StageType.STAGE3_RELOAD ) {
                        // STAGE2 에서 선택한 메뉴를 윶지하기 위해 조건문 처리
                        if ( stage == StageType.STAGE3 ){
                            menu.printSelectedItem(input);
                        }
                        shoppingBag.printAskAddItem();
                        input = sc.next();
                        stage = DetermineStage.stage3Check(input, menu, shoppingBag);

                        // STAGE4 카테고리 선택 or 결제 선택 입출력 부분
                        while (stage == StageType.STAGE4 || stage == StageType.STAGE4_RELOAD ) {
                            menu.printCategory();
                            shoppingBag.printSelectOrder(menu);
                            input = sc.next();
                            stage = DetermineStage.stage4Check(input, menu, shoppingBag);

                            // STAGE5 장바구니 결제 입출력 부분
                            while ( stage == StageType.STAGE5 || stage == StageType.STAGE5_RELOAD ) {
                                input = sc.next();
                                stage = DetermineStage.stage5Check(input);

                                while ( stage == StageType.STAGE6 || stage == StageType.STAGE6_RELOAD){
                                    shoppingBag.printDiscountInfo();
                                    input = sc.next();
                                    stage = DetermineStage.stage6Check(input);
                                    if (stage == StageType.STAGE1){
                                        shoppingBag.printCompleteOrder(input);
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

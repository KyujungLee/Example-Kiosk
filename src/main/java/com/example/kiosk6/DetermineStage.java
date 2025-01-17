package com.example.kiosk6;

public class DetermineStage {

    // stage 의 동작권한을 결정하는 클래스
    // 각 STAGE 에 맞는 입력조건을 검사 후 다음 STAGE 동작권한을 부여할지 말지 결정
    public static StageType stage1Check(String input, Menu menu){
        try {
            isCategoryIndex(input, menu);
            isExit(input);
        } catch (StageThrow e){
            return e.getStage();
        }
        return StageType.STAGE2;
    }
    public static StageType stage2Check(String input, Menu menu){
        try{
            isMenuIndex(input, menu);
            isGoBack(input, menu);
        } catch (StageThrow e){
            return e.getStage();
        }
        return StageType.STAGE3;
    }
    public static StageType stage3Check(String input, Menu menu, ShoppingBag shoppingBag){
        try{
            isAddShoppingBag(input,menu,shoppingBag);
        } catch (StageThrow e){
            return e.getStage();
        }
        return StageType.STAGE4;
    }
    public static StageType stage4Check(String input, Menu menu, ShoppingBag shoppingBag) {
        try {
            isOrderIndex(input, menu);
            isCheckShoppingBag(input, menu, shoppingBag);
            isExit(input);
        } catch (StageThrow e){
            return e.getStage();
        }
        return StageType.STAGE2;
    }
    public static StageType stage5Check(String input){
        try{
            isTryOrder(input);
        } catch (StageThrow e){
            return e.getStage();
        }
        return StageType.STAGE6;
    }
    public static StageType stage6Check(String input){
        try {
            isDiscount(input);
        } catch (StageThrow e){
            return e.getStage();
        }
        return StageType.STAGE1;
    }

    // 카테고리의 숫자보다 더 큰 수 혹은 문자 입력을 받을 시 STAGE 다시 시작
    private static void isCategoryIndex(String input, Menu menu) throws StageThrow {
        long categoryCount = menu.getMenu().stream()
                .map(MenuItem::getCategoryType)
                .distinct()
                .count();
        try {
            if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > categoryCount ){
                System.out.println("\n올바른 숫자를 입력해주세요");
                throw new StageThrow(StageType.STAGE1_RELOAD);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n올바른 숫자를 입력해주세요");
            throw new StageThrow(StageType.STAGE1_RELOAD);
        }
    }
    private static void isExit(String input) throws StageThrow {
        if ("0".equals(input)) {
            System.out.println("\n프로그램을 종료합니다");
            throw new StageThrow(StageType.EXIT);
        }
    }

    // 선택한 카테고리의 메뉴 숫자보다 더 큰 수 혹은 문자 입력을 받을 시 STAGE 다시 시작
    private static void isMenuIndex(String input, Menu menu) throws StageThrow {
        try {
            if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > menu.getSelectedMenu().size() ){
                System.out.println("\n올바른 숫자를 입력해주세요");
                throw new StageThrow(StageType.STAGE2_RELOAD);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n올바른 숫자를 입력해주세요");
            throw new StageThrow(StageType.STAGE2_RELOAD);
        }
    }
    private static void isGoBack(String input, Menu menu) throws StageThrow {
        if ("0".equals(input)) {
            menu.initSelectedMenu();
            System.out.println("\n뒤로 돌아갑니다");
            throw new StageThrow(StageType.STAGE1);
        }
    }

    // 1 입력시 장바구니에 저장 후 다음 STAGE 로 이동 or
    // 2 입력시 선택한 아이템 초기화 후 메뉴선택 STAGE 로 이동 or
    // 제시한 선택지보다 큰 수 혹은 문자 입력시 STAGE 다시 시작
    private static void isAddShoppingBag(String input, Menu menu, ShoppingBag shoppingBag) throws StageThrow {
        try {
            if("1".equals(input)){
                shoppingBag.printAddItem(menu);
                System.out.println("\n장바구니에 저장되었습니다.");
            } else if ("2".equals(input)){
                menu.initSelectedItem();
                System.out.println("\n취소되었습니다.");
                throw new StageThrow(StageType.STAGE2);
            } else {
                System.out.println("\n올바른 숫자를 입력해주세요");
                throw new StageThrow(StageType.STAGE3_RELOAD);
            }
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("\n올바른 숫자를 입력해주세요");
            throw new StageThrow(StageType.STAGE3_RELOAD);
        }

    }

    // 카테고리의 숫자 + 결제선택 + 결제취소 보다 더 큰 수 혹은 문자 입력을 받을 시 STAGE 다시 시작
    private static void isOrderIndex(String input, Menu menu) throws StageThrow {
        long categoryCount = menu.getMenu().stream()
                .map(MenuItem::getCategoryType)
                .distinct()
                .count();
        try {
            if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > categoryCount + 2 ){
                System.out.println("\n올바른 숫자를 입력해주세요");
                throw new StageThrow(StageType.STAGE4_RELOAD);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n올바른 숫자를 입력해주세요");
            throw new StageThrow(StageType.STAGE4_RELOAD);
        }
    }
    // 결제 선택 시 다음 STAGE 로 이동 or
    // 결제 취소 시 장바구니를 비우고 초기 STAGE 로 이동
    private static void isCheckShoppingBag(String input, Menu menu, ShoppingBag shoppingBag) throws StageThrow {
        try {
            int categoryCount = (int) menu.getMenu().stream()
                    .map(MenuItem::getCategoryType)
                    .distinct()
                    .count();
            if( categoryCount+1 == Integer.parseInt(input) ){
                shoppingBag.printCheckOrder();
                throw new StageThrow(StageType.STAGE5);
            } else if ( categoryCount+2 == Integer.parseInt(input) ){
                shoppingBag.emptyShoppingBag();
                System.out.println("\n장바구니를 비웠습니다.");
                throw new StageThrow(StageType.STAGE1);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n올바른 숫자를 입력해주세요");
            throw new StageThrow(StageType.STAGE4_RELOAD);
        }

    }

    // 1 입력 시 결제완료 출력 후 초기 STAGE 로 이동
    // 2 입력 시 이전 STAGE 로 이동
    // 제시한 선택지보다 큰 수 혹은 문자 입력시 STAGE 다시 시작
    private static void isTryOrder(String input) throws StageThrow {
        try {
            if("1".equals(input)){
                throw new StageThrow(StageType.STAGE6);
            } else if ("2".equals(input)){
                System.out.println("\n메뉴판으로 돌아갑니다");
                throw new StageThrow(StageType.STAGE4);
            } else {
                System.out.println("\n올바른 숫자를 입력해주세요");
                throw new StageThrow(StageType.STAGE5_RELOAD);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n올바른 숫자를 입력해주세요");
            throw new StageThrow(StageType.STAGE5_RELOAD);
        }
    }

    private static void isDiscount(String input) throws StageThrow {
        DiscountInfo[] discountInfo = DiscountInfo.values();
        try {
            if ( Integer.parseInt(input) < 0 || Integer.parseInt(input) > discountInfo.length){
                System.out.println("\n올바른 숫자를 입력해주세요");
                throw new StageThrow(StageType.STAGE6_RELOAD);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n올바른 숫자를 입력해주세요");
            throw new StageThrow(StageType.STAGE6_RELOAD);
        }

    }





}

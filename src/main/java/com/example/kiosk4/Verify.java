package com.example.kiosk4;

public class Verify {

    // 아래 3개 매서드를 하나로 뭉치는 매서드(카테고리에 대한 검증)
    public static void handlingExit(String selectCategory, Menu menu) throws Exception, ArrayIndexOutOfBoundsException, NumberFormatException{
        isExit(selectCategory);
        isInt(selectCategory);
        isCategoryIndex(selectCategory, menu);
    }
    // 아래 3개 매서드를 하나로 뭉치는 매서드 (각 카테고리별 검증)
    public static void handlingGoBack(String selectCategory, String selectMenu, Menu menu) throws Exception, ArrayIndexOutOfBoundsException, NumberFormatException{
        isGoBack(selectMenu);
        isInt(selectMenu);
        isMenuIndex(selectCategory,selectMenu,menu);
    }


    // selectCategory 에 0을 입력하면 종료되는 매서드
    public static void isExit(String selectCategory) throws Exception{
        if ("0".equalsIgnoreCase(selectCategory)) {
            throw new Exception("\n프로그램을 종료합니다");
        }
    }
    // selectMenu 에 0을 입력하면 뒤로가는 매서드
    public static void isGoBack(String selectMenu) throws Exception{
        if ("0".equalsIgnoreCase(selectMenu)) {
            throw new Exception("\n뒤로 돌아갑니다");
        }
    }

    // selectCategory 가 Category 리스트의 인덱스 범위 안쪽인지 검증하는 매서드
    public static void isCategoryIndex(String selectCategory, Menu menu) throws ArrayIndexOutOfBoundsException{
        if(Integer.parseInt(selectCategory) < 0 || Integer.parseInt(selectCategory) > menu.getCategory().size()){
            throw new ArrayIndexOutOfBoundsException("\n올바른 카테고리를 선택해주세요");
        }
    }
    // 선택된 카테고리에서 selectMenu 가 리스트의 인덱스 범위 안쪽인지 검증하는 매서드
    public static void isMenuIndex(String SelectCategory,String selectMenu, Menu menu) throws ArrayIndexOutOfBoundsException{
        switch ( menu.getCategory().get(Integer.parseInt(SelectCategory) -1 ) ) {
            case "Burgers":
                if(Integer.parseInt(selectMenu) < 0 || Integer.parseInt(selectMenu) > menu.getBurgers().size()){
                    throw new ArrayIndexOutOfBoundsException("\n올바른 메뉴를 선택해주세요");
                };
                break;
            case "Drinks":
                if(Integer.parseInt(selectMenu) < 0 || Integer.parseInt(selectMenu) > menu.getDrinks().size()){
                    throw new ArrayIndexOutOfBoundsException("\n올바른 메뉴를 선택해주세요");
                };
                break;
            case "Desserts":
                if(Integer.parseInt(selectMenu) < 0 || Integer.parseInt(selectMenu) > menu.getDesserts().size()){
                    throw new ArrayIndexOutOfBoundsException("\n올바른 메뉴를 선택해주세요");
                };
                break;
            default:
                break;
        }
    }
    // input이 parseInt가 가능한지 검증하는 매서드
    public static void isInt(String input) throws NumberFormatException{
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new NumberFormatException("\n올바른 숫자를 입력해주세요");
        }
    }
}

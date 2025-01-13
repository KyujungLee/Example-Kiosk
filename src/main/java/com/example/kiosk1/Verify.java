package com.example.kiosk1;

public class Verify {

    // 아래 3개 매서드를 하나로 뭉치는 매서드
    public static void handling(String input) throws Exception, ArrayIndexOutOfBoundsException, NumberFormatException{
            isExit(input);
            isInt(input);
            isInsideMenuIndex(input);
    }

    // input에 0을 입력하면 종료되는 매서드
    public static void isExit(String input) throws Exception{
        if ("0".equalsIgnoreCase(input)) {
            throw new Exception("\n프로그램을 종료합니다");
        }
    }

    // input이 메뉴의 인덱스 범위 안쪽인지 검증하는 매서드
    public static void isInsideMenuIndex(String input) throws ArrayIndexOutOfBoundsException{
        MenuItem menuItem = new MenuItem();
        if(Integer.parseInt(input) < 0 || Integer.parseInt(input) >= menuItem.getMenuItemAll().length){
            throw new ArrayIndexOutOfBoundsException("\n올바른 메뉴를 선택해주세요");
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

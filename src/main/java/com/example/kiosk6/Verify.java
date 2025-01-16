package com.example.kiosk6;

public class Verify {

    public static String categoryCheck(String input, Menu menu){
        try {
            isNumeric(input);
            isCategoryIndex(input, menu);
            isExit(input);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            return StateType.CONTINUE.getState();
        } catch (Exception e){
            return StateType.BREAK.getState();
        }
        return StateType.CLEAR.getState();
    }
    public static String menuCheck(String input, Menu menu){
        try{
            isNumeric(input);
            isMenuIndex(input, menu);
            isGoBack(input);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            return StateType.CONTINUE.getState();
        } catch (Exception e){
            return StateType.BREAK.getState();
        }
        return StateType.CLEAR.getState();
    }
    public static String addItemCheck(String input, Menu menu, ShoppingBag shoppingBag){
        try{
            isAddShoppingBag(input,menu,shoppingBag);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            return StateType.CONTINUE.getState();
        } catch (Exception e) {
            return StateType.BREAK.getState();
        }
        return StateType.CLEAR.getState();
    }
    public static String orderCheck(String input, Menu menu, ShoppingBag shoppingBag){
        try {
            isOrderIndex(input, menu);
            isCheckShoppingBag(input, shoppingBag);
            isExit(input);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            return StateType.CONTINUE.getState();
        } catch (Exception e){
            return StateType.BREAK.getState();
        }
        return StateType.CLEAR.getState();
    }
    public static String tryOrderCheck(String input, ShoppingBag shoppingBag){
        try{
            isTryOrder(input,shoppingBag);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            return StateType.CONTINUE.getState();
        } catch (Exception e) {
            return StateType.BREAK.getState();
        }
        return StateType.CLEAR.getState();
    }


    private static void isNumeric(String input) throws NumberFormatException{
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new NumberFormatException("\n올바른 숫자를 선택해주세요");
        }
    }
    private static void isExit(String input) throws Exception{
        if ("0".equals(input)) {
            throw new Exception("\n프로그램을 종료합니다");
        }
    }
    private static void isGoBack(String input) throws Exception{
        if ("0".equals(input)) {
            throw new Exception("\n뒤로 돌아갑니다");
        }
    }
    private static void isAddShoppingBag(String input, Menu menu, ShoppingBag shoppingBag) throws Exception, ArrayIndexOutOfBoundsException{
        if("1".equals(input)){
            shoppingBag.addItem(menu);
        } else if ("2".equals(input)){
            throw new Exception("\n취소되었습니다.");
        } else {
            throw new ArrayIndexOutOfBoundsException("\n올바른 숫자를 선택해주세요");
        }
    }
    private static void isCheckShoppingBag(String input, ShoppingBag shoppingBag) throws ArrayIndexOutOfBoundsException{
        if("4".equals(input)){
            shoppingBag.printCheckOrder();
        } else if ("5".equals(input)){
            shoppingBag.removeItem();
            throw new ArrayIndexOutOfBoundsException("\n장바구니를 비웠습니다.");
        } else {
            throw new ArrayIndexOutOfBoundsException("\n올바른 숫자를 선택해주세요");
        }
    }
    private static void isTryOrder(String input, ShoppingBag shoppingBag) throws Exception, ArrayIndexOutOfBoundsException{
        if("1".equals(input)){
            shoppingBag.printCompleteOrder();
            throw new Exception(); // 루프 종료, 맨 처음으로
        } else if ("2".equals(input)){
            throw new Exception("\n메뉴판으로 돌아갑니다"); // 루프 종료, 맨 처음으로
        } else {
            throw new ArrayIndexOutOfBoundsException("\n올바른 숫자를 선택해주세요"); // 루프 지속
        }
    }
    private static void isCategoryIndex(String input, Menu menu) throws ArrayIndexOutOfBoundsException{
        if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > menu.getCategoryOfMenu().size() ){
            throw new ArrayIndexOutOfBoundsException("\n올바른 카테고리를 선택해주세요");
        }
    }
    private static void isOrderIndex(String input, Menu menu) throws ArrayIndexOutOfBoundsException{
        if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > menu.getCategoryOfMenu().size()+2 ){
            throw new ArrayIndexOutOfBoundsException("\n카테고리 혹은 주문여부를 선택해주세요");
        }
    }
    private static void isMenuIndex(String input, Menu menu) throws ArrayIndexOutOfBoundsException{
        if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > menu.getSelectedMenu().size() ){
            throw new ArrayIndexOutOfBoundsException("\n올바른 메뉴를 선택해주세요");
        }
    }

}

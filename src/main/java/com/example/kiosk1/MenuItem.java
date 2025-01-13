package com.example.kiosk1;

public class MenuItem {

    // 변경할 수 없는 menuItem 배열 필드.
    private final String[] menuItem = {
            "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
            "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
            "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
            "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거"
    };

    // menuItem 배열을 리턴하는 매서드.
    public String[] getMenuItemAll(){
        return menuItem;
    }

    // 입력된 숫자에 해당하는 menuItem을 리턴하는 매서드.
    public String getMenuSelect(int selectNumber){
        return menuItem[selectNumber];
    }

    // 메뉴를 순회하며 전체를 출력하는 매서드.
    public void getMenuPrintAll(){
        for (String menu : menuItem){
            System.out.println(menu);
        }
    }

}

package com.example.kiosk3;

import java.util.ArrayList;
import java.util.List;

public class MenuItem{

    // 모든 메뉴의 정보를 담은 menuItems 리스트 필드 생성.
    private List<List<String>> menuItems = new ArrayList<>();


    // menuItem 배열을 리턴하는 매서드.
    public List<List<String>> getMenuItemAll(){
        return menuItems;
    }

    // 입력된 숫자의 인덱스에 해당하는 menuItem 을 리턴하는 매서드.
    public List<String> getMenuSelect(int selectNumber){
        return menuItems.get(selectNumber);
    }

    // 메뉴를 순회하며 전체를 출력하는 매서드.
    public void getMenuPrintAll(){
        for (List<String> menu : menuItems){
            System.out.print(menuItems.indexOf(menu)+1+". ");
            for (String item : menu) {
                System.out.print(item+", ");
            }
            System.out.println();
        }
    }

    // 입력받은 메뉴 정보를 리스트로 만들어서, menuItems 리스트 필드에 저장.
    public void setMenuItem(String menuName, String menuPrice, String menuDescription){
        List<String> result = new ArrayList<>();
        result.add(menuName);
        result.add(menuPrice);
        result.add(menuDescription);
        menuItems.add(result);
    }

}

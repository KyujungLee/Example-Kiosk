package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBag {
    private List<MenuItem> shoppingBag = new ArrayList<>();

    public void printAskAddItem(){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.print("1. 확인        2. 취소");
    }

    public void addItem(Menu menu){
        shoppingBag.add(menu.getSelectedItem());
        System.out.println("\n"+menu.getSelectedItem().getName()+" 이 추가되었습니다.");
        menu.getSelectedItem() = new MenuItem();
    }

    public void printSelectOrder(){
        System.out.println("4. Orders  |  장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel  |  진행중인 주문을 취소합니다.");
    }

    public void removeItem(){
        shoppingBag = new ArrayList<>();
    }
    public List<MenuItem> getShoppingBag(){
        return shoppingBag;
    }
    public void printCheckOrder(){
        System.out.println("아래와 같이 주분하시겠습니까?\n");
        Double totalPrice = 0.0;
        System.out.println("[ Orders ]");
        for (MenuItem item : shoppingBag){
            System.out.println(item.getName() + " | W " + item.getPrice() + " | " +item.getDescription());
            totalPrice += item.getPrice();
        }
        System.out.println("\n[ Total ]");
        System.out.println("W "+totalPrice);
        System.out.println("\n1. 주문        2. 메뉴판");
    }
    public void printCompleteOrder(){
        Double totalPrice = 0.0;
        for (MenuItem item : shoppingBag){
            totalPrice += item.getPrice();
        }
        System.out.println("주문이 완료되었습니다. 금액은 W"+totalPrice+" 입니다.");
        removeItem();
    }
}

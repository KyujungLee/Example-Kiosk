package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingBag {

    // 장바구니 관리 클래스

    // 최종 선택한 메뉴를 저장하는 장바구니 필드
    private List<MenuItem> shoppingBag = new ArrayList<>();

    public void printChooseAddItem(){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }
    // 선택한 메뉴를 저장 후, menu 인스턴스에 저장된 메뉴와 아이템을 초기화
    public void printAddItem(Menu menu){
        shoppingBag.add(menu.getSelectedItem());
        System.out.println("\n"+menu.getSelectedItem().getName()+" 이 추가되었습니다.");
        menu.initSelectedItem();
        menu.initSelectedMenu();
    }
    public void printChoosePayment(Menu menu){
        int categoryCount = (int) menu.getMenu().stream()
                .map(MenuItem::getCategoryType)
                .distinct()
                .count();
        System.out.println( (categoryCount+1) + ". Orders  |  장바구니를 확인 후 주문합니다.");
        System.out.println( (categoryCount+2) + ". Cancel  |  진행중인 주문을 취소합니다.");
    }
    public void printProceedPayment(){
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        double totalPrice = shoppingBag.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
        System.out.println("[ Orders ]");
        String printShoppingBag = shoppingBag.stream()
                .map(item -> item.getName() + " | W " + item.getPrice() + " | " + item.getDescription())
                .collect(Collectors.joining("\n"));
        System.out.println(printShoppingBag);
        System.out.println("\n[ Total ]");
        System.out.println("W "+totalPrice);
        System.out.println("\n1. 주문        2. 메뉴판");
    }
    public void printChooseDiscount(){
        System.out.println("할인 정보를 입력해주세요.");
        DiscountInfo[] discountInfo = DiscountInfo.values();
        for (int i = 0 ; i < discountInfo.length ; i++){
            System.out.println((i+1)+". "+discountInfo[i]+" : "+ (100.0-discountInfo[i].getDiscount())+"%" );
        }
    }
    // 주문 완료 시 총금액 출력, 장바구니를 비우는 매서드
    public void printCompletePayment(String input){
        int select = Integer.parseInt(input)-1;
        DiscountInfo[] discountInfo = DiscountInfo.values();
        double totalPrice = shoppingBag.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
        System.out.println("주문이 완료되었습니다. 금액은 W"+totalPrice*discountInfo[select].getDiscount()/100.0+" 입니다.");
        emptyShoppingBag();
    }
    // 장바구니를 비우는 매서드
    public void emptyShoppingBag(){
        shoppingBag = null;
    }


}

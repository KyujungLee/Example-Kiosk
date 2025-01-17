package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 각 메뉴들을 리스트로 모아 관리하는 클래스
    private List<MenuItem> menu = new ArrayList<>();

    // 이전 단계에서 선택한 카테고리, 메뉴에 해당하는 정보를 저장하는 필드
    private List<MenuItem> selectedMenu = new ArrayList<>();
    private MenuItem selectedItem;


    // 카테고리 출력 매서드
    public void printCategory(){
        CategoryType[] category = CategoryType.values();
        System.out.println("[ MAIN MANU ]");
        for (int i = 0 ; i < category.length ; i++){
            System.out.println(i+1+". "+category[i]);
        }
        System.out.println("0. 종료");
    }
    // 선택한 카테고리의 메뉴 출력 매서드
    public void printMenu(String input){
        CategoryType[] category = CategoryType.values();
        int select = Integer.parseInt(input) - 1 ;
        selectedMenu = menu.stream()
                .filter(menuItem -> menuItem.getCategoryType() == category[select])
                .toList();
        System.out.println("[ "+category[select]+" MANU ]");
        for (int i = 0 ; i < selectedMenu.size() ; i++){
            System.out.println(i+1+". "+selectedMenu.get(i).getName() + " | W " + selectedMenu.get(i).getPrice() + " | " +selectedMenu.get(i).getDescription());
        }
        System.out.println("0. 뒤로가기");
    }
    // 선택한 메뉴를 출력하는 매서드
    public void printSelectedItem(String input){
        int select = Integer.parseInt(input) - 1 ;
        selectedItem = selectedMenu.get(select);
        System.out.println("선택한 메뉴: "+selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " +selectedItem.getDescription());
    }


    public List<MenuItem> getMenu(){
        return menu;
    }
    public List<MenuItem> getSelectedMenu(){
        return selectedMenu;
    }
    public MenuItem getSelectedItem(){
        return selectedItem;
    }


    public void setMenu(MenuItem menuItem){
        menu.add(menuItem);
    }
    // 선택하여 저장한 메뉴와 아이템을 초기화하는 매서드
    public void initSelectedItem(){
        this.selectedItem = null;
    }
    public void initSelectedMenu(){
        this.selectedMenu = null;
    }

}

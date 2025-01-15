package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 각 MenuItem 인스턴스를 메뉴별로 분류한 리스트필드 + 필드 종류를 담은 카테고리 라수투필드
    private List<MenuItem> burgers = new ArrayList<>();
    private List<MenuItem> drinks = new ArrayList<>();
    private List<MenuItem> desserts = new ArrayList<>();
    private List<String> category = new ArrayList<>();

    // 선택된 카테고리를 나열하여 출력하는 매서드
    public void PrintSelectedCategory(String selectCategory) {
        System.out.println();
        String select = getCategory().get(Integer.parseInt(selectCategory) - 1);
        switch (select) {
            case "Burgers":
                PrintBurgers();
                break;
            case "Drinks":
                PrintDrinks();
                break;
            case "Desserts":
                PrintDesserts();
                break;
            default:
                break;
        }
    }
    // 선택된 인스턴스의 필드를 출력하는 매서드
    public void PrintSelectedMenu(String selectCategory, String selectMenu){
        System.out.println();
        int index = Integer.parseInt(selectMenu) -1;
        String select = getCategory().get(Integer.parseInt(selectCategory) -1);
        System.out.print("선택한 메뉴 : ");
        switch ( select ) {
            case "Burgers":
                System.out.println( getBurgers().get(index).getName()+" | "+getBurgers().get(index).getPrice()+" | "+getBurgers().get(index).getDescription() );
                break;
            case "Drinks":
                System.out.println( getDrinks().get(index).getName()+" | "+getDrinks().get(index).getPrice()+" | "+getDrinks().get(index).getDescription() );
                break;
            case "Desserts":
                System.out.println( getDesserts().get(index).getName()+" | "+getDesserts().get(index).getPrice()+" | "+getDesserts().get(index).getDescription() );
                break;
            default:
                break;
        }
    }

    // 카테고리 리스트필드를 순환하여 출력하는 매서드
    public void PrintCategory(){
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        for (int i = 0 ; i < category.size() ; i++){
            System.out.println( (i+1) + ". " + category.get(i) );
        }
        System.out.println("0. 종료");
    }
    // 버거 리스트필드를 순환하여 출력하는 매서드
    public void PrintBurgers(){
        System.out.println();
        System.out.println("[ BURGERS MENU ]");
        for (int i = 0 ; i < burgers.size() ; i++){
            System.out.println( (i+1) + ". " + burgers.get(i).getName() + " | " +burgers.get(i).getPrice()+ " | " +burgers.get(i).getDescription() );
        }
        System.out.println("0. 뒤로가기");
    }
    // 음료 리스트필드를 순환하여 출력하는 매서드
    public void PrintDrinks(){
        System.out.println();
        System.out.println("[ DRINKS MENU ]");
        for (int i = 0 ; i < drinks.size() ; i++){
            System.out.println( (i+1) + ". " + drinks.get(i).getName() + " | " +drinks.get(i).getPrice()+ " | " +drinks.get(i).getDescription() );
        }
        System.out.println("0. 뒤로가기");
    }
    // 간식 리스트필드를 순환하여 출력하는 매서드
    public void PrintDesserts(){
        System.out.println();
        System.out.println("[ DESSERTS MENU ]");
        for (int i = 0 ; i < desserts.size() ; i++){
            System.out.println( (i+1) + ". " + desserts.get(i).getName() + " | " +desserts.get(i).getPrice()+ " | " +desserts.get(i).getDescription() );
        }
        System.out.println("0. 뒤로가기");
    }

    // Menu 인스턴스 각각의 리스트필드를 반환하는 매서드
    public List<String> getCategory(){
        return category;
    }
    public List<MenuItem> getBurgers(){
        return burgers;
    }
    public List<MenuItem> getDrinks(){
        return drinks;
    }
    public List<MenuItem> getDesserts(){
        return desserts;
    }

    // Menu 인스턴스 생성 시 각 리스트필드에 필요한 MenuItem 인스턴스를 추가하는 매서드
    public void setBurgers(MenuItem menuItem){
        if (burgers.isEmpty()){
            category.add("Burgers");
        }
        burgers.add(menuItem);
    }
    public void setDrinks(MenuItem menuItem){
        if (drinks.isEmpty()){
            category.add("Drinks");
        }
        drinks.add(menuItem);
    }
    public void setDesserts(MenuItem menuItem){
        if (desserts.isEmpty()){
            category.add("Desserts");
        }
        desserts.add(menuItem);
    }
}

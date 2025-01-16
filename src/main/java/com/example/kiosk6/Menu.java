package com.example.kiosk6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Menu {
    private LinkedHashMap<String, List<MenuItem>> categoryOfMenu = new LinkedHashMap<>();
    private List<MenuItem> burgers = new ArrayList<>();
    private List<MenuItem> drinks = new ArrayList<>();
    private List<MenuItem> desserts = new ArrayList<>();
    private List<MenuItem> selectedMenu = new ArrayList<>();
    private MenuItem selectedItem;


    public void printCategory(){
        List<String> categoryKeys = new ArrayList<>(categoryOfMenu.keySet());
        System.out.println("[ MAIN MANU ]");
        for (int i = 0 ; i < categoryKeys.size() ; i++){
            System.out.println(i+1+". "+categoryKeys.get(i));
        }
        System.out.println("0. 종료");
    }
    public void printMenu(String input){
        int select = Integer.parseInt(input) - 1 ;
        String selectedCategory = new ArrayList<>( categoryOfMenu.keySet() ).get(select);
        selectedMenu = categoryOfMenu.get(selectedCategory);
        System.out.println("[ "+selectedCategory.toUpperCase()+" MANU ]");
        for (int i = 0 ; i < selectedMenu.size() ; i++){
            System.out.println(i+1+". "+selectedMenu.get(i).getName() + " | W " + selectedMenu.get(i).getPrice() + " | " +selectedMenu.get(i).getDescription());
        }
        System.out.println("0. 뒤로가기");
    }
    public void printSelectedItem(String input){
        int select = Integer.parseInt(input) - 1 ;
        selectedItem = selectedMenu.get(select);
        System.out.println("선택한 메뉴: "+selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " +selectedItem.getDescription());
    }

    public LinkedHashMap<String, List<MenuItem>> getCategoryOfMenu(){
        return categoryOfMenu;
    }
    public List<MenuItem> getSelectedMenu(){
        return selectedMenu;
    }
    public MenuItem getSelectedItem(){
        return selectedItem;
    }

    public void setBurgers(MenuItem menuItem) {
        burgers.add(menuItem);
        setCategory(CategoryType.BURGERS.getCategory(), burgers);
    }
    public void setDrinks(MenuItem menuItem) {
        drinks.add(menuItem);
        setCategory(CategoryType.DRINKS.getCategory(), drinks);
    }
    public void setDesserts(MenuItem menuItem) {
        desserts.add(menuItem);
        setCategory(CategoryType.DESSERTS.getCategory(), desserts);
    }
    public void setCategory(String category, List<MenuItem> menu){
        categoryOfMenu.put( category, menu );
    }

}

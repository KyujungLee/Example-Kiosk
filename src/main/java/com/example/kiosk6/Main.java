package com.example.kiosk6;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ShoppingBag shoppingBag = new ShoppingBag();

        menu.setBurgers(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.setBurgers(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.setBurgers(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.setBurgers(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        menu.setDrinks(new MenuItem("Cola",2.1,"시원한 코카콜라"));
        menu.setDrinks(new MenuItem("evian",9.9,"고급물"));
        menu.setDrinks(new MenuItem("TapWater",6.9,"수돗물"));
        menu.setDrinks(new MenuItem("Coffee",5.4,"따듯한 아이스 아메리카노"));

        menu.setDesserts(new MenuItem("Cake",11.8,"10단 초코 케이크"));
        menu.setDesserts(new MenuItem("Bread",10.7,"혈당직빵 꽈베기"));
        menu.setDesserts(new MenuItem("IceCream",8.5,"민트초코피스타치오 구구콘"));
        menu.setDesserts(new MenuItem("fruit",5.4,"각종 과일조각 (랜덤)"));

        Kiosk.start(menu, shoppingBag);
    }
}

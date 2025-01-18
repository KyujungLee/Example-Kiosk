package com.example.kiosk6;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ShoppingBag shoppingBag = new ShoppingBag();

        // MenuItem 필드에 CateggoryType 까지 포함하여 명시
        menu.setMenu(new MenuItem(CategoryType.BURGERS ,"ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.setMenu(new MenuItem(CategoryType.BURGERS ,"SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.setMenu(new MenuItem(CategoryType.BURGERS ,"Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.setMenu(new MenuItem(CategoryType.BURGERS ,"Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        menu.setMenu(new MenuItem(CategoryType.DRINKS ,"Cola",2.1,"시원한 코카콜라"));
        menu.setMenu(new MenuItem(CategoryType.DRINKS ,"evian",9.9,"고급물"));
        menu.setMenu(new MenuItem(CategoryType.DRINKS ,"TapWater",0.0,"수돗물"));
        menu.setMenu(new MenuItem(CategoryType.DRINKS ,"Coffee",5.4,"따듯한 아이스 아메리카노"));

        menu.setMenu(new MenuItem(CategoryType.DESSERTS ,"Cake",11.8,"10단 초코 케이크"));
        menu.setMenu(new MenuItem(CategoryType.DESSERTS ,"Bread",10.7,"혈당직빵 꽈베기"));
        menu.setMenu(new MenuItem(CategoryType.DESSERTS ,"IceCream",8.5,"민트초코피스타치오 구구콘"));
        menu.setMenu(new MenuItem(CategoryType.DESSERTS ,"fruit",5.4,"각종 과일조각 (랜덤)"));

        Kiosk.start(menu, shoppingBag);
    }
}

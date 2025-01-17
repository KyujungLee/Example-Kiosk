package com.example.kiosk6;

public class MenuItem <T> {

    // 각 메뉴의 인스턴스를 생성하는 클래스
    // 제네릭 T를 사용하여, 이름과 상세설명 부분은 타입에 제약을 받지 않고 동일한 타입이 되도록 설정
    private CategoryType categoryType;
    private T name;
    private Double price;
    private T description;

    public MenuItem(CategoryType categoryType, T name, Double price, T description){
        this.categoryType = categoryType;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public CategoryType getCategoryType(){
        return categoryType;
    }
    public T getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public T getDescription() {
        return description;
    }

}

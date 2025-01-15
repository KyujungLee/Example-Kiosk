package com.example.kiosk4;

public class MenuItem{

    // 인스턴스 생성에 필요한 필드
    private String name;
    private Double price;
    private String description;

    // 필요한 필드를 정의하는 인스턴스 생성자
    public MenuItem (String name, Double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 각 인스턴스의 필드값을 리턴하는 매서드
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
}

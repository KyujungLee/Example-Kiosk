package com.example.kiosk6;

public enum CategoryType {
    BURGERS("burgers"),DRINKS("drinks"),DESSERTS("desserts");
    private String category;

    CategoryType(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}

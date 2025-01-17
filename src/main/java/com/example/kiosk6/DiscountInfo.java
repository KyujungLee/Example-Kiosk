package com.example.kiosk6;

public enum DiscountInfo {
    국가유공자(90.0),
    군인(95.0),
    학생(97.0),
    일반(100.0);

    private Double discount;

    DiscountInfo(Double discount){
        this.discount = discount;
    }

    public Double getDiscount(){
        return discount;
    }
}

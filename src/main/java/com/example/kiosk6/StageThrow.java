package com.example.kiosk6;

public class StageThrow extends Exception{

    // Exception 을 상속받아, STAGE 결정 클래스에서 StageType 클래스의 상수를 throw 할 수 있도록 하는 클래스
    private StageType stage;

    public StageThrow(StageType stage){
        this.stage = stage;
    }

    public StageType getStage() {
        return stage;
    }
}

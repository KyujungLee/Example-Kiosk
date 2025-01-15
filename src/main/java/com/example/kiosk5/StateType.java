package com.example.kiosk5;

public enum StateType {
    EXIT("Exit"), GOBACK("GoBack");
    private String state;

    StateType(String state){
        this.state=state;
    }

    public String getState(){
        return state;
    }

    // state 를 한번더 체크하고 조건문을 실행시키는 매서드
    public static Boolean act(String state){
        for (StateType type : StateType.values()){
            if(type.getState().equals(state)){
                return true;
            }
        }
        return false;
    }
}

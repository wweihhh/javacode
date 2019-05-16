package com.bittech;

public class TestSOFError {
    private int stackDeep = 0;

    public void setDeep() {
        stackDeep++;
        setDeep();
    }

    public static void main(String[] args) {
        TestSOFError testSOFError = new TestSOFError();
        try{
            testSOFError.setDeep();
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println("Call deep"+testSOFError.stackDeep);
        }
    }
}

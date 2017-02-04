package com.javarush.test.level15.lesson12.home04;

public class Earth implements Planet
{
    private static Earth instance;
    private Earth(){}

    public static Earth getInstance(){
        if(instance==null) {
            System.out.println(Planet.EARTH);
            instance = new Earth();
        }
        return instance;
    }
}

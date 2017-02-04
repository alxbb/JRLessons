package com.javarush.test.level15.lesson12.home04;

public class Moon implements Planet
{
    private static Moon instance;
    private Moon(){}

    public static Moon getInstance(){
        if(instance==null) {
            System.out.println(Planet.MOON);
            instance = new Moon();
        }
        return instance;
    }
}

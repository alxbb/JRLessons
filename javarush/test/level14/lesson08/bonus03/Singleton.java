package com.javarush.test.level14.lesson08.bonus03;

public class  Singleton
{
    private static Singleton instance;

    private Singleton() {instance=new Singleton();}

    public static Singleton getInstance(){
        return instance;
    }
}

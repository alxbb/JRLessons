package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth() { return 100; }
    String getDescription(){
        String sout = super.getDescription();
        sout += " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return sout;
    }
}

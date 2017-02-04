package com.javarush.test.level02.lesson03.task02;

/* Три собаки - это сила
Создать 3 объекта типа Dog (собака) и присвоить им имена "Max", "Bella", "Jack".
*/
public class Solution
{
    public static void main(String[] args)
    {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        dog1.name = "Max";
        dog2.name = "Bella";
        dog3.name = "Jack";

        //напишите тут ваш код
    }

    public static class Dog
    {
        public String name;
    }
}

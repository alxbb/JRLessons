package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        int Age;
        int Tall;
        boolean Sex;
        String Name;
        String Color;
        String Country;

        public Human(String name)
        {
            Name = name;
        }

        public Human(String name, int age)
        {
            Name = name;
            Age = age;
        }

        public Human(int age, int tall, boolean sex, String name)
        {
            Age = age;
            Tall = tall;
            Sex = sex;
            Name = name;
        }

        public Human(int age, boolean sex, String name, String color)
        {
            Age = age;
            Sex = sex;
            Name = name;
            Color = color;
        }

        public Human(boolean sex, String name, String color, String country)
        {
            Sex = sex;
            Name = name;
            Color = color;
            Country = country;
        }

        public Human(String name, String color, String country)
        {
            Name = name;
            Color = color;
            Country = country;
        }

        public Human(int tall, boolean sex, String name)
        {
            Tall = tall;
            Sex = sex;
            Name = name;
        }

        public Human(String color, String country)
        {
            Color = color;
            Country = country;
        }

        public Human(boolean sex, String color, String country)
        {
            Sex = sex;
            Color = color;
            Country = country;
        }

        public Human(int age, int tall, boolean sex, String name, String color, String country)
        {
            Age = age;
            Tall = tall;
            Sex = sex;
            Name = name;
            Color = color;
            Country = country;
        }
    }
}

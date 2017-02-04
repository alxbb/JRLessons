package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human GrF1 = new Human("Дедушка Вася", true, 90);
        Human GrM1 = new Human("Бабушка Маша", false, 85);
        Human GrF2 = new Human("Дедушка Петя", true, 80);
        Human GrM2 = new Human("Бабушка Моня", false, 75);
        Human F = new Human("Папа Толя", true, 40);
        Human M = new Human("Мама Лиза", false, 35);
        Human C1 = new Human("Сын Паша", true, 14);
        Human C2 = new Human("Дочь Глаша", false, 10);
        Human C3 = new Human("Сын Лаша", true, 8);
        GrF1.addChildren(F);
        GrM1.addChildren(F);
        GrF2.addChildren(M);
        GrM2.addChildren(M);
        M.addChildren(C1);
        M.addChildren(C2);
        M.addChildren(C3);
        F.addChildren(C1);
        F.addChildren(C2);
        F.addChildren(C3);

        System.out.println(GrF1.toString());
        System.out.println(GrM1.toString());
        System.out.println(GrF2.toString());
        System.out.println(GrM2.toString());
        System.out.println(F.toString());
        System.out.println(M.toString());
        System.out.println(C1.toString());
        System.out.println(C2.toString());
        System.out.println(C3.toString());
    }

    public static class Human
    {
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, Boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            children = new ArrayList<Human>();
        }

        public void addChildren(Human child){
            children.add(child);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

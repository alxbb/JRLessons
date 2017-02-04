package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human GrF1 = new Human("Дед1", true, 90);
        Human GrF2 = new Human("Дед2", true, 80);
        Human GrM1 = new Human("Баба1", false, 85);
        Human GrM2 = new Human("Баба2", false, 75);
        Human Fa   = new Human("Папа", true, 40, GrF1, GrM1);
        Human Mo   = new Human("Мама", false, 35, GrF2, GrM2);
        Human Ch1  = new Human("Аня", false, 17, Fa, Mo);
        Human Ch2  = new Human("Дима", true, 15, Fa, Mo);
        Human Ch3  = new Human("Игорь", true, 10, Fa, Mo);

        System.out.println(GrF1);
        System.out.println(GrF2);
        System.out.println(GrM1);
        System.out.println(GrM2);
        System.out.println(Fa);
        System.out.println(Mo);
        System.out.println(Ch1);
        System.out.println(Ch2);
        System.out.println(Ch3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;


        public Human(String name)
        {
            this.name = name;
            this.sex = false;
            this.age = 0;
            this.father = null;
            this.mother = null;
        }
        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = null;
            this.mother = null;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}

package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String GrFaName = reader.readLine();
        Cat catGrFa = new Cat(GrFaName);

        String GrMaName = reader.readLine();
        Cat catGrMa = new Cat(GrMaName);

        String FaName = reader.readLine();
        Cat catFa = new Cat(FaName, catGrFa, null);

        String MaName = reader.readLine();
        Cat catMa = new Cat(MaName, null, catGrMa);

        String SonName = reader.readLine();
        Cat catSon = new Cat(SonName, catFa, catMa);

        String DotName = reader.readLine();
        Cat catDot = new Cat(DotName, catFa, catMa);

        System.out.println(catGrFa);
        System.out.println(catGrMa);
        System.out.println(catFa);
        System.out.println(catMa);
        System.out.println(catSon);
        System.out.println(catDot);
    }

    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString()
        {
            String vOut = "";

            if (mother == null)
                vOut += ", no mother";
            else
                vOut += ", mother is " + mother.name;
            if (father == null)
                vOut += ", no father";
            else
                vOut += ", father is " + father.name;

            return "Cat name is " + name + vOut;
        }
    }

}

package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        String name;
        int y, m, d;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();
        y = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());

        System.out.println("Меня зовут " + name);
        System.out.println("Я родился " + d + "." + m + "." + y);
    }

}


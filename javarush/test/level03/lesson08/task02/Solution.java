package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String name;
        int x, y;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();
        x = Integer.parseInt(br.readLine());
        y = Integer.parseInt(br.readLine());
        System.out.println(name + " получает " + x + " через " + y + " лет.");

    }
}
package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> towns = new ArrayList<String>();
        List<String> names = new ArrayList<String>();

        while (true)
        {
            String town = reader.readLine();
            if (town.isEmpty()) break;

            String name = reader.readLine();
            if (name.isEmpty()) break;
            towns.add(town);
            names.add(name);
        }

        String town = reader.readLine();
        if(towns.contains(town))
            System.out.println(names.get(towns.indexOf(town)));
        else
            System.out.println("Not found : "+ town);
    }
}

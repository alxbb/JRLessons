package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String,Integer> map = new HashMap<>();
        map.put("JANUARY", 1);
        map.put("FEBRUARY", 2);
        map.put("MARCH", 3);
        map.put("APRIL", 4);
        map.put("MAY", 5);
        map.put("JUNE", 6);
        map.put("JULY", 7);
        map.put("AUGUST", 8);
        map.put("SEPTEMBER", 9);
        map.put("OCTOBER", 10);
        map.put("NOVEMBER", 11);
        map.put("DECEMBER", 12);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String month = br.readLine();
        int m=0;

        for(Map.Entry<String,Integer> pair : map.entrySet()){
            if((pair.getKey()).equals(month.toUpperCase())) m = pair.getValue();
        }

        System.out.println(month + " is " + m + " month");

    }

}

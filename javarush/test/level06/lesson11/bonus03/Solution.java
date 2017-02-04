package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] dig = new int[5];

        for (int i = 0; i < 5; i++)
        {
            dig[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < dig.length; i++) {
            boolean rpt=true;
            for (int j = 0; j < dig.length-i-1; j++)
            {
                if (dig[j] > dig[j+1]) {
                    rpt = true;
                    int tmp  = dig[j];
                    dig[j]   = dig[j+1];
                    dig[j+1] = tmp;
                }
                if (!rpt) break;
            }
        }

        for (int i = 0; i < 5 ; i++) System.out.println(dig[i]);
    }
}


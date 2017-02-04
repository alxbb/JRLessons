package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int d1 = 0;
        int maximum = 0;
        int N = Integer.parseInt(reader.readLine());

        for (int i=0; i<N; i++){
            d1 = Integer.parseInt(reader.readLine());
            if (i == 0) maximum = d1;
            else maximum = maximum < d1 ? d1 : maximum;
        }

        System.out.println(maximum);
    }
}

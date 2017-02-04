package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int a, b, c, mid=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());
            c = Integer.parseInt(br.readLine());

            if ((a >= b && a <= c) || (a >= c && a <= b)) mid = a;
            if ((b >= a && b <= c) || (b >= c && b <= a)) mid = b;
            if ((c >= a && c <= b) || (c >= b && c <= a)) mid = c;
            System.out.println(mid);
    }
}

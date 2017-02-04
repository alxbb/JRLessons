package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a, b, c;
        int[] m = new int[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        m[0]=max(a,max(b,c));
        m[2]=min(a,min(b,c));
        if(a != m[0] && a != m[2]) m[1] = a;
        if(b != m[0] && b != m[2]) m[1] = b;
        if(c != m[0] && c != m[2]) m[1] = c;
        if(a==b) m[1] = a;
        if(b==c) m[1] = b;

        System.out.println(m[0]);
        System.out.println(m[1]);
        System.out.println(m[2]);
    }
    static int min(int a, int b){return a<=b?a:b;}
    static int max(int a, int b){return a>=b?a:b;}
}

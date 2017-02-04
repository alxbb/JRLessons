package com.javarush.test.level04.lesson10.task03;

import java.io.*;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i=1, N;
        String sOut;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sOut = br.readLine();
        N = Integer.parseInt(br.readLine());

        while (i<=N){
            System.out.println(sOut);
            i++;
        }

    }
}

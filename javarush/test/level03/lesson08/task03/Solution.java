package com.javarush.test.level03.lesson08.task03;

/* Скромность украшает человека
Ввести с клавиатуры имя и вывести надпись:
name зарабатывает $5,000. Ха-ха-ха!
Пример: Тимур зарабатывает $5,000. Ха-ха-ха!
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();

        System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");

    }
}
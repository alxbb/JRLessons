package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int sum=0;
        String in="0";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ( true ){
            in = br.readLine();
            if (in.equals("сумма")) break;
            sum += Integer.parseInt(in);
        }
        System.out.println(sum);
    }
}

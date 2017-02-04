package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] arr = s.toCharArray();
        boolean caps = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==32) caps=true;
            if (caps && arr[i]!=32){
                caps = false;
                arr[i] = Character.toUpperCase(s.charAt(i));
            }
        }
        s = new String(arr);
        System.out.println(s);
}
}

package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int minl;
        ArrayList<String> strl = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) strl.add(br.readLine());

        minl = strl.get(0).length();
        for (int i = 1; i < strl.size(); i++) if (minl > strl.get(i).length()) minl = strl.get(i).length();

        for (int i = 0; i < strl.size(); i++)
            if (strl.get(i).length() == minl)
                System.out.println(strl.get(i));
    }
}

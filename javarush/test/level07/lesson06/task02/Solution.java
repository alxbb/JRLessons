package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int max=0;
        int maxl=0;
        ArrayList<String> strl = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strl.add(br.readLine());
        }

        for (int i = 0; i < strl.size(); i++) if (maxl < strl.get(i).length()) maxl = strl.get(i).length();

        for (int i = 0; i < strl.size(); i++)
            if (strl.get(i).length() == maxl)
                System.out.println(strl.get(i));
    }
}

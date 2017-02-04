package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] big = new int[20];
        int[] sm1 = new int[10];
        int[] sm2 = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < big.length; i++) {
            big[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < sm1.length; i++) {
            sm1[i] = big[i];
            sm2[i] = big[i+10];
        }
        for (int i = 0; i < sm2.length; i++) {
            System.out.println(sm2[i]);
        }
    }
}

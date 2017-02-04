package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

//        for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
//        System.out.println("");
        sort(array);
//        for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        int count=0;
        for (int i = 0; i < array.length; i++) {
            boolean swap = false;
            for (int j = 0; j < array.length-i-1; j++) {
                count++;
                int tmp = array[j];
                if(array[j+1] > array[j]) {
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    swap = true;
                }
            }
            if(!swap) break;
        }
        System.out.println("count = " + count);
    }
}

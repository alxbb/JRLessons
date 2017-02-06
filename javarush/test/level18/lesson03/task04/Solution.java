package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        int[] bytes = new int[256];
        int min = Integer.MAX_VALUE;
        FileInputStream fis = new FileInputStream(fname);

        if(fis.available() == 0) return;

        while(fis.available() > 0){
            int b = fis.read();
            bytes[b]++;
        }


        for (int i = 0; i < 256 ; i++) {
            if( bytes[i] < min && bytes[i] > 0) min = bytes[i];
        }

        for (int i = 0; i < 256; i++) {
            if(bytes[i] == min ) System.out.print( i + " ");
        }

        br.close();
        fis.close();
    }
}
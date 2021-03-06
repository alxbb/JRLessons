package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        int[] bytes = new int[256];
        int max = 0;
        long time = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(fname);

        if(fis.available() == 0) return;

        while(fis.available() > 0){
            int b = fis.read();
            bytes[fis.read()]++;
            if( bytes[b] > max ) max = bytes[b];
        }
        System.out.println("max = " + max);
        for (int i = 0; i < 256; i++) {
            if(bytes[i] == max ) System.out.print( i + " ");
        }

        br.close();
        fis.close();
    }
}

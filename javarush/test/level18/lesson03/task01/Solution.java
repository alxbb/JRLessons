package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        String fname = br.readLine();
        FileInputStream fis = new FileInputStream(fname);
        while(fis.available() > 0 ) {
            int ch = fis.read();
            if(ch > max) max = ch;
        }
        System.out.println(max);
        br.close();
        fis.close();
    }
}

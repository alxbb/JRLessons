package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        String fname = br.readLine();
        FileInputStream fis = new FileInputStream(fname);
        if(fis.available()==0) return;
        while(fis.available() > 0 ) {
            int ch = fis.read();
            if(ch < min) min = ch;
        }
        System.out.println(min);
        br.close();
        fis.close();
    }
}

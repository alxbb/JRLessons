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
        FileInputStream fis = new FileInputStream(fname);
        byte[] chars = new byte[256];
        int max = 0;

        if (fis.available() == 0 ) return;

        while(fis.available() > 0){
            byte nextChar = (byte)fis.read();
            chars[nextChar]++;
            if(chars[nextChar] > max) max = chars[nextChar];
        }

        for (int i = 0; i < chars.length; i++) { if ( chars[i] == max ) System.out.print(((char)(byte)i) + " "); }

        br.close();
        fis.close();
    }
}

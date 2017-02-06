package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        int[] bytes = new int[256];
        int max = 0;
        FileInputStream fis = new FileInputStream(fname);

        if(fis.available() == 0) return;

        while(fis.available() > 0){
            int b = fis.read();
            bytes[b]++;
        }

        for (int i = 0; i < 256; i++) {
            if(bytes[i] > 0 ) System.out.print( i + " ");
        }

        br.close();
        fis.close();
    }
}

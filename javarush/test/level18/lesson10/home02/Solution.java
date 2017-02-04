package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.Math.round;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length==0)return;
        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        int flength = fis.available();
        if(flength==0)return;

        while(fis.available()>0){
            if(fis.read() == ' ') count++;
        }
        System.out.println((double) round(count*10000.00/flength)/100);
        fis.close();
    }
}

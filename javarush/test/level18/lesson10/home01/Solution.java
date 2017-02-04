package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length==0)return;
        FileInputStream fis = new FileInputStream(args[0]);
        if(fis.available()==0)return;
        int count = 0;

        while(fis.available()>0){
            int next = fis.read();
            if((next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z')) count++;
        }
        System.out.println(count);
        fis.close();
    }
}

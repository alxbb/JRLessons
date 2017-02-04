package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fin  = br.readLine();
        String fout = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(fin));
        BufferedWriter fw = new BufferedWriter(new FileWriter(fout));
        while(fr.ready()){
            String sin = fr.readLine();
            System.out.println(sin);
            String[] digits = sin.split("\\s+");
            for (int i = 0; i < digits.length; i++) {
                System.out.print(digits[i] + " ");
                if(digits[i].matches("\\d+")) fw.write(digits[i] + " ");
            }
        }
        fw.close();
        fr.close();
    }
}

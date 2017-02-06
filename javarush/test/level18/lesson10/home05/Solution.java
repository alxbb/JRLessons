package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.regex.Pattern;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = br.readLine();
        String fname2 = br.readLine();
        br.close();

        FileInputStream fis = new FileInputStream(fname1);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fname2));

        byte[] buf = new byte[fis.available()];
        fis.read(buf);

        Pattern pat = Pattern.compile(" ");
        String[] strings = pat.split(new String(buf));

        for (int i = 0; i < strings.length; i++) {
            if(strings[i]==null) continue;
            long res = round(Double.parseDouble(strings[i]));
            bw.write((res + " "));
        }
        fis.close();
        bw.close();
    }
}

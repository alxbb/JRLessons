package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = br.readLine();
        String fname2 = br.readLine();
        br.close();

        FileInputStream  fis1 = new FileInputStream(fname1);
        FileInputStream  fis2 = new FileInputStream(fname2);

        int size1 = fis1.available();
        int size2 = fis2.available();
        byte[] buff = new byte[size1+size2];
        fis2.read(buff, 0, size2);
        fis1.read(buff, size2, size1);

        fis1.close();
        fis2.close();

        FileOutputStream fos = new FileOutputStream(fname1);
        fos.write(buff);
        fos.close();
    }
}

package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fin  = br.readLine();
        String fout = br.readLine();
        byte[] buff;
        int fsize;

        FileInputStream  fis = new FileInputStream(fin);
        FileOutputStream fos = new FileOutputStream(fout);

        fsize = fis.available();
        if( fsize == 0) return;
        buff = new byte[fsize];
        fsize = fis.read(buff);

        for (int i = fsize-1; i >= 0 ; i--) {
            fos.write(buff[i]);
        }

        br.close();
        fis.close();
        fos.close();
    }
}

package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fin, fout1, fout2;
        int size1=0, size2=0, size3=0;
        byte[] buffer;
        fin   = br.readLine();
        fout1 = br.readLine();
        fout2 = br.readLine();

        FileInputStream  fis  = new FileInputStream(fin);
        FileOutputStream fos1 = new FileOutputStream(fout1);
        FileOutputStream fos2 = new FileOutputStream(fout2);

        size1 = fis.available();
        if( size1 == 0 ) return;

        if( size1%2 == 0) {
            size2 = size3 = size1/2;
        } else {
            size3 = size1/2;
            size2 = size3+1;
        }

        buffer = new byte[size1];
        size1 = fis.read(buffer);
        fos1.write(buffer,0, size2);
        fos2.write(buffer, size2, size3);

        br.close();
        fis.close();
        fos1.close();
        fos2.close();
    }
}

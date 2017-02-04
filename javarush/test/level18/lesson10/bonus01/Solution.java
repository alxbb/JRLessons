package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if(args.length == 0) return;
        File fIn = new File(args[1]);
        File fOut = new File(args[2]);

        if( "-e".equals(args[0])) encode(fIn, fOut);
        if( "-d".equals(args[0])) decode(fIn, fOut);
    }

    public static void encode(File in, File out) {
        int fiSize = 0;
        byte[] buff = new byte[0];
        FileOutputStream fos = null;

        try {
            FileInputStream fis = new FileInputStream(in);
            fiSize = fis.available();
            fos = new FileOutputStream(out);
            buff = new byte[fiSize];
            fis.read(buff);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < fiSize/2; i++) {
            byte b;
            b = buff[i];
            buff[i] = buff[fiSize-i-1];
            buff[fiSize-i-1] = b;
        }

        try {
            fos.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void decode(File in, File out) {
        int fiSize = 0;
        byte[] buff = new byte[0];
        FileOutputStream fos = null;

        try {
            FileInputStream fis = new FileInputStream(in);
            fiSize = fis.available();
            fos = new FileOutputStream(out);
            buff = new byte[fiSize];
            fis.read(buff);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < fiSize/2; i++) {
            byte b;
            b = buff[i];
            buff[i] = buff[fiSize-i-1];
            buff[fiSize-i-1] = b;
        }

        try {
            fos.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.test.level09.lesson11.bonus02;



import java.io.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует, то
программа должна вывести надпись «Файл не существует.» и еще раз прочитать имя файла с консоли, а уже потом считывать файл для записи.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName;
        String destinationFileName;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        while(true) {
            sourceFileName = reader.readLine();
            if ((new File(sourceFileName)).exists())
            {
                fileInputStream = new FileInputStream(sourceFileName);
                break;
            } else{
                System.out.println("Файл не существует.");
            }
        }

        destinationFileName = reader.readLine();
        fileOutputStream = new FileOutputStream(destinationFileName);

        while (true)
        {
            int data = fileInputStream.read();
            if(data == -1) break;
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}

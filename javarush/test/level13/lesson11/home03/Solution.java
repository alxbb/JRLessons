package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fname;
        File file;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fname = br.readLine();
        file = new File(fname);
        InputStream fis = new FileInputStream(file);
        int size = fis.available();

        for (int i = 0; i < size; i++)
            System.out.print( (char)(fis.read()));

        fis.close();
        br.close();
    }
}

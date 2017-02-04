package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String inputString, fname;
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file;
        FileWriter fos;

        fname = br.readLine();
        file = new File(fname);
        fos = new FileWriter(file);

        while ( true ){
            inputString = br.readLine();
            list.add(inputString);
            if ("exit".equals(inputString)) break;
        }

        for (int i = 0; i < list.size(); i++) {
            fos.write(list.get(i)+"\n");
        }
        br.close();
//        fos.flush();
        fos.close();
    }
}

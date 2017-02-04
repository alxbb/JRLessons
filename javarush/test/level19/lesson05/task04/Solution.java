package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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
            fw.write( fr.readLine().replaceAll("\\.", "\\!") );
        }

        fr.close();
        fw.close();
    }
}

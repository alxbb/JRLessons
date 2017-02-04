package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
 запятая (,), точка с запятой (;), двоеточие (:) и точка (.);
 второму — знаки: восклицательный (!) и вопросительный (?), многоточие (…) и тире (—)».
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
            String in = fr.readLine();
            fw.write(in.replaceAll("\\p{Punct}",""));
        }

        fr.close();
        fw.close();
    }
}

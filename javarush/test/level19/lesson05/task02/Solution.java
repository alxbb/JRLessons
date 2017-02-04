package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        br.close();

        File file = new File(fname);
        if(!file.exists())return;

        BufferedReader fr = new BufferedReader(new FileReader(file));
        char[] chars = new char[(int) file.length()];
        fr.read(chars);
        fr.close();
        String[] words = (new String(chars).split("[^a-zA-Zа-яА-ЯёЁ]+"));
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if("world".equals(words[i])) count++;
        }
        System.out.println(count);
    }
}

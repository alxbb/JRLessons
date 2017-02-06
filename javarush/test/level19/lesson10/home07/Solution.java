package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length < 2) return;
        if(!(new File(args[0]).exists())) return;
        List<String> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

        while(br.ready()){
            String[] in = br.readLine().split("\\s");
            for (int i = 0; i < in.length; i++) {
                if(in[i].length() > 6 ) {
                    list.add(in[i]);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + (i==list.size()-1?"":","));
        }

        br.close();
        bw.close();
    }
}

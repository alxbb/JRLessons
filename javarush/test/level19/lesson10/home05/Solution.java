package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length < 2) return;
        if(!(new File(args[0]).exists())) return;

        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));

        while(fr.ready()){
            String[] in = fr.readLine().split(" ");
            for (int i = 0; i < in.length; i++) {
                if(in[i].matches(".*\\d.*")) fw.write(in[i] + " ");
            }
        }
        fr.close();
        fw.close();
    }
}

package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        br.close();
        if(!(new File(fname).exists())) return;

        BufferedReader fr = new BufferedReader(new FileReader(fname));

        while(fr.ready()){
            String in = fr.readLine();
            System.out.println(new StringBuffer(in).reverse());
        }
        fr.close();
    }
}

package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(fname));

        String regexp = "(\\b(\\d{1,2})\\b)";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher;

        while(fr.ready()){
            String in = fr.readLine();
            System.out.println(in);
            matcher = pattern.matcher(in);
            int start = 0;
            while(true){
                if (matcher.find()) {
                    String sId = matcher.group();
                    int idx = Integer.parseInt(sId);
                    String val = map.get(idx);
                    System.out.println("idx = " + idx + " // val = " + val);
                    if (map.containsKey(idx)) {
                        in = matcher.replaceFirst(val);
                        sleep(500);
                    } else continue;
                }else break;
                matcher = pattern.matcher(in);
                System.out.println(in);
            }
            System.out.println(in);
        }
    }
}

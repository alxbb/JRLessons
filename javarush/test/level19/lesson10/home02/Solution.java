package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) return;
        Map<String, Double> map = new TreeMap<>();

        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        double max = 0;
        while(fr.ready()){
            String[] s = fr.readLine().split(" ");
            Double value = Double.parseDouble(s[1]);
            if(map.containsKey(s[0])) map.put(s[0], (value += map.get(s[0])));
            else map.put(s[0], value);
            if(value > max) max = value;
        }

        for (Map.Entry<String, Double> pair : map.entrySet()){
            if(pair.getValue() >= max) System.out.println(pair.getKey());
        }

        fr.close();
    }
}

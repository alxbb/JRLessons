package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String[] params;
        ArrayList<Pair> list = new ArrayList<>();
        String url;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        url = br.readLine();

        url = url.substring(url.indexOf("?")+1);
        params = url.split("&");
        for (int i = 0; i <params.length; i++) {
            list.add(new Pair(params[i]));
        }

        for (int i = 0; i < list.size(); i++) {
            String k = list.get(i).getKey();
            System.out.print(k + " ");
        }
        System.out.println("");

        for (int i = 0; i < list.size(); i++) {
            String k = list.get(i).getKey();
            if("obj".equals(k)){
                String v = list.get(i).getValue();
                if (v.matches("[0-9.]+"))alert(new Double(v));
                else alert(v);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static class Pair{
        private String key, value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Pair(String s) {
            int pos;
            if (s.contains("=")) {
                pos = s.indexOf("=");
                this.key = s.substring(0, pos);
                this.value = s.substring(pos + 1);
            } else {
                this.key = s;
                this.value = null;
            }
            //System.out.println(key + "||" + value);
        }

        public String getKey() {return key;}

        public String getValue() {return value;}
    }
}

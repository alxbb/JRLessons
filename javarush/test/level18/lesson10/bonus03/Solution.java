package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        br.close();

        if(!new File(fname).exists()) return;
        if(args.length == 0) return;

        if("-u".equals(args[0])){
            update(fname, args);
        }else if("-d".equals(args[0])){
            delete(fname, args);
        }
    }

    public static void delete(String fname, String[] args) throws IOException {
        List<String> list = new LinkedList<>();
        String current;
        BufferedReader br = new BufferedReader(new FileReader(fname));
        while((current = br.readLine()) != null){
            if(args[1].trim().equals(current.substring(0,8).trim())) {
                continue;
            }
            list.add(current);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
            for(String s: list){
                bw.write(s);
                bw.newLine();
            }
            bw.close();
    }

    public static void update(String fname, String[] args) throws IOException {
        List<String> list = new LinkedList<>();
        String current;
        BufferedReader br = new BufferedReader(new FileReader(fname));
        while((current = br.readLine()) != null){
            String id = current.substring(0,8).trim();
            if(args[1].trim().equals(id)) {
                String name = "";
                if (args.length >= 5) {
                    for (int i = 2; i <= args.length - 3; i++) {
                        name = name + args[i] + (i < args.length - 3 ? " " : "");
                    }
                }
                String price = args[args.length - 2];
                String quantity = args[args.length - 1];
                current = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", id, name, price, quantity);
            }
            list.add(current);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
            for(String s: list){
            bw.write(s);
            bw.newLine();
            }
            bw.close();
    }
}

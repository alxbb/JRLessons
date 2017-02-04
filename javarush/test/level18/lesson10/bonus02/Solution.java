package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        br.close();
        if( !(new File(fname).exists())) return;

        br = new BufferedReader(new FileReader(fname));
        int maxId = 0;
        String nextLine = "";
        while((nextLine = br.readLine())!=null){
            int id = Integer.parseInt(nextLine.substring(0,8).trim());
            if(id > maxId) maxId = id;
        }
        br.close();

        if(!("-c".equals(args[0])) || args.length < 4) return;
        String name="";
        if(args.length >= 4){
            for (int i = 1; i <= args.length-3 ; i++) {
                name = name + args[i] + (i < args.length-3?" ":"");
            }
        }
        String price=args[args.length-2];
        String quantity=args[args.length-1];
        String newProduct = "" + (maxId+1) + name + price + quantity;
        System.out.println(newProduct);
        newProduct = String.format("%-8.8s%-30.30s%-8.8s%-4.4s","" + (maxId+1), name, price, quantity);
        System.out.println(newProduct);

        BufferedWriter bw = new BufferedWriter(new FileWriter(fname, true));
        bw.append(newProduct);
        bw.close();
    }
}

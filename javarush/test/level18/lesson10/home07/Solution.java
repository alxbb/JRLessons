package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length==0) return;
        int id = Integer.parseInt(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));

        while (true) {
            String s = fr.readLine();
            if (s == null) break;
            Product prod = new Product(s);
            if (prod.getId() == id){ System.out.println(prod);}
        }

        br.close();
        fr.close();
    }

    static class Product{
        private int id;
        private String product = "";
        private double price;
        private int quantity;

        public Product(String s) {
            Pattern pat = Pattern.compile(" ");
            String[] list = pat.split(s);
            int size = list.length;

            this.id = Integer.parseInt(list[0]);
            this.price = Double.parseDouble(list[size-2]);
            this.quantity = Integer.parseInt(list[size-1]);
            for (int i =1; i < size-2; i++)
                this.product += list[i] + (i==(size-3)?"":" ");
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return id + " " + product + " " + price + " " + quantity;
        }
    }
}

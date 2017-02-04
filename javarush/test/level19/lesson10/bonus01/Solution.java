package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        //        String s1 = "строка1";
//        String s2 = "строка2";
//        System.out.println(s1.compareTo(s2));
//        System.out.println(s2.compareTo(s2));
//        System.out.println(s2.compareTo(s1));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = br.readLine();
        String fname2 = br.readLine();
        br.close();

        if(!(new File(fname1).exists()) || !(new File(fname2).exists()) ) return;
        BufferedReader f1r = new BufferedReader(new FileReader(fname1));
        BufferedReader f2r = new BufferedReader(new FileReader(fname2));
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        while (f1r.ready()){l1.add(f1r.readLine());}
        while (f2r.ready()){l2.add(f2r.readLine());}
        f1r.close();
        f2r.close();
        int s1 = l1.size();
        int s2 = l2.size();

        for (int i = 0, j = 0; i < s1; ) {

            switch (l1.get(i).compareTo(l2.get(j))){
                case 0:
                    lines.add(new LineItem(Type.SAME, l1.get(i)));
                    j++;i++;
                    break;
                case -1:
                    if(l1.get(i).compareTo(l2.get(j+1))==0){
                        lines.add(new LineItem(Type.ADDED, l2.get(j++)));
                    } else lines.add(new LineItem(Type.REMOVED, l1.get(i++)));
                    break;
                case 1:
                    lines.add(new LineItem(Type.ADDED, l2.get(j++)));
                    break;
            }
            if(j == s2-1 && i < s1-1)j--;
        }

        for(LineItem li : lines){
            System.out.println(li);
        }
        f1r.close();
        f2r.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }
}

package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> inFiles = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in=null;
        String out=null;

        while(!("end".equals(in=br.readLine()))){
            if("".equals(in)) continue;
            inFiles.put(Integer.parseInt(in.substring(in.lastIndexOf(".part")+5)), in);
            if(out==null) out = in.substring(0, in.lastIndexOf(".part"));
        }
        br.close();

        FileOutputStream fos = new FileOutputStream(out);

        for(Map.Entry<Integer,String> pair : inFiles.entrySet()){
            if(!(new File(pair.getValue()).exists())) continue;
            FileInputStream fis = new FileInputStream(pair.getValue());
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            if(fis!=null) fis.close();
            fos.write(buf);
        }
        if(fos!=null) fos.close();
    }
}

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
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> inputList = new ArrayList<>();
        String[] fileList;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos;
        String finName, foutName = null;
        byte[] buf;

        while( !"end".equals(finName=br.readLine())) {
            if(!finName.contains(".part")) continue;
            if( !(new File(finName).exists())) continue;
            inputList.add(finName);
        }
        fileList = new String[inputList.size()];

        for( String s : inputList){
            int part = Integer.parseInt(s.substring(s.lastIndexOf(".part")+5));
            fileList[part] = s;
        }

        for (int i = 0; i < fileList.length; i++) {
            String s = fileList[i];
            if (!"".equals(s)) {
                foutName = s.substring(0,s.lastIndexOf(".part"));
                break;
            }
        }

        fos = new FileOutputStream(foutName);

        for (int i = 0; i < fileList.length; i++) {
            String s = fileList[i];
            if ("".equals(s) || !(new File(s).exists())) continue;
            fis = new FileInputStream(s);
            buf = new byte[fis.available()];
            fis.read(buf);
            fos.write(buf);
        }
        if( fos != null) fos.close();
        if( fis != null) fis.close();
        br.close();

    }
}
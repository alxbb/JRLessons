package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr;
        String fname1, fname2;
        try {
            fname1 = br.readLine();
            fname2 = br.readLine();

            fr = new BufferedReader(new FileReader(new File(fname1)));
            while (true) {
                String s = fr.readLine();
                if (s == null) break;
                allLines.add(s);
            }
            fr.close();

            fr = new BufferedReader(new FileReader(new File(fname2)));
            while (true) {
                String s = fr.readLine();
                if (s == null) break;
                forRemoveLines.add(s);
            }
            fr.close();

                try {
                new Solution().joinData();
                } catch (CorruptedDataException e) {
                    System.out.println("Данные не найдены");
                }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

}

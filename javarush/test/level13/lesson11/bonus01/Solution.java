package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname;
        File file;
        Scanner scanner;

        fname=br.readLine();
        file = new File(fname);
        scanner=new Scanner(file);

        while(scanner.hasNext()){
            int i=scanner.nextInt();
            if (i%2==0) list.add(i);
        }

        Collections.sort(list);

        System.out.println(list);

    }
}

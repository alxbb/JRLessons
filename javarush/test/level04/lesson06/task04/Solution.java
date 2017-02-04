package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны».
Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String n1, n2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n1 = br.readLine();
        n2 = br.readLine();

        if(n1.equals(n2)) System.out.println("Имена идентичны");
        else if(n1.length()==n2.length()) System.out.println("Длины имен равны");

    }
}

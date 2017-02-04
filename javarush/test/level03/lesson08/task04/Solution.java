package com.javarush.test.level03.lesson08.task04;

/* Спонсор - это звучит гордо
Ввести с клавиатуры два имени и вывести надпись:
name1 проспонсировал name2, и она стала известной певицей.
Пример:
Коля проспонсировал Лену, и она стала известной певицей.
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
        System.out.println(n1 + " проспонсировал " + n2 + ", и она стала известной певицей.");
    }
}
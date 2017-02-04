package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b;
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        System.out.println(gcd(a,b));
    }

    public static int gcd(int a, int b){
        int x=a, y=b;
        while (x!=0&&y!=0){
            if(x>y) x%=y;
            else y%=x;
        }
        return x+y;
    }
}

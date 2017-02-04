package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sysOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        testString.printSomething();
        String[] s = baos.toString().split("[\\s\\c\\r]+");
        int result = 0;
        if("+".equals(s[1])) result = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
        if("-".equals(s[1])) result = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
        if("*".equals(s[1])) result = Integer.parseInt(s[0]) * Integer.parseInt(s[2]);

        System.setOut(sysOut);
        ps.close();

        System.out.printf("%s %s %s %s %d",s[0] ,s[1] ,s[2] ,s[3], result );
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


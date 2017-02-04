package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) { //1
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, int value) { //2
        System.out.println("Заполняем объектами int");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, byte value) { //3
        System.out.println("Заполняем объектами byte");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, short value) { //4
        System.out.println("Заполняем объектами short");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, char value) { //5
        System.out.println("Заполняем объектами char");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, double value) { //6
        System.out.println("Заполняем объектами double");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, float value) { //7
        System.out.println("Заполняем объектами float");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, Integer value) { //8
        System.out.println("Заполняем объектами Integer");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, Double value) { //9
        System.out.println("Заполняем объектами Double");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}

package com.javarush.test.level14.lesson08.bonus01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try { //1
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //2
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //3
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //4
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //5
            int i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //6
            int i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //7
            int i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //8
            int i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //9
            int i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //10
            int i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}

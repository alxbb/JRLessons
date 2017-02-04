package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread st0 = new SpecialThread();
        SpecialThread st1 = new SpecialThread();
        SpecialThread st2 = new SpecialThread();
        SpecialThread st3 = new SpecialThread();
        SpecialThread st4 = new SpecialThread();
        Thread thread0=new Thread(st0);
        list.add(thread0);
        Thread thread1=new Thread(st1);
        list.add(thread1);
        Thread thread2=new Thread(st2);
        list.add(thread2);
        Thread thread3=new Thread(st3);
        list.add(thread3);
        Thread thread4=new Thread(st4);
        list.add(thread4);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}

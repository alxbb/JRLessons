package com.javarush.test.level16.lesson10.task03;

/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/

import static java.lang.Thread.sleep;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread tt = new TestThread();

        tt.start();
        tt.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        @Override
        public void run()
        {
        }
    }
}

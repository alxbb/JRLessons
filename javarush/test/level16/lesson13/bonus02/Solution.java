package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new TestTread1());
        threads.add(new TestTread2());
        threads.add(new TestTread3());
        threads.add(new TestTread4());
        threads.add(new TestTread5());
    }

    public static class TestTread1 extends Thread{
        @Override
        public void run() { while(true){} }
    }

    public static class TestTread2  extends Thread{
        @Override
        public void run() {
            try {
                    while(true) sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
            }
        }
    }

    public static class TestTread3 extends Thread{
        @Override
        public void run() {
                try {
                    while(!this.isInterrupted()) {
                        System.out.println("Ура");
                        sleep(500);
                    }
                } catch (InterruptedException e) {}
        }
    }

    public static class TestTread4  extends Thread implements Message{
        @Override
        public void run() {
            while(!this.isInterrupted()){
            }
        }

        @Override
        public void showWarning() {
            if( this.isAlive() )this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class TestTread5  extends Thread{
        int sum=0;
        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                try {
                    String s = br.readLine();
                    if ("N".equals(s)) {
                        br.close();
                        break;}
                    sum += Integer.parseInt(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        }
    }
}

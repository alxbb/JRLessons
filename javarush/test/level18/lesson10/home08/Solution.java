package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> fileList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        String fname;

        while(true){
            fname = br.readLine();
            if("exit".equals(fname)) break;
            fileList.add(fname);
        }
        br.close();

        if(fileList.size()==0)return;
        for(String s : fileList){
            threadList.add(new ReadThread(s));
        }
        for(Thread t : threadList){
            t.start();
        }

        while (true){
            int alive=0;
            for(Thread t : threadList){
                if(t.isAlive()){ alive++; t.join();}
            }
            sleep(500);
            if (alive==0) break;
        }

        for (Map.Entry<String,Integer> pair: resultMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static class ReadThread extends Thread {
        public static volatile int threadCount = 0;
        private String fileName;
        private FileInputStream fis;

        public ReadThread(String fileName) {
            super();
            this.fileName = fileName;
        }

        @Override
        public void run() {
            threadCount++;
            int max = 0, imax=0;
            int[] bytes = new int[256];
            int fsize=0;
            byte[] file;
            try {
                fis = new FileInputStream(this.fileName);
                fsize = fis.available();
                file = new byte[fsize];
                fis.read(file);
                for (int i = 0; i < fsize; i++) {
                    int bt = file[i];
                    if(bt < 0) bt += 256;
                    bytes[bt]++;
                }
                sleep(1000);
                for (int i = 0; i < bytes.length; i++) {
                    if(bytes[i] > max) {
                        max = bytes[i];
                        imax = i;
                    }
                }

                synchronized (resultMap){resultMap.put(fileName, imax);}
                fis.close();
                threadCount--;
                this.yield();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

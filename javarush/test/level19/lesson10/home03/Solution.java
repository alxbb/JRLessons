package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if(args.length == 0) return;
        if(!(new File(args[0]).exists())) return;
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        Calendar cal;

        while(fr.ready()){
            String[] in = fr.readLine().split(" ");
            String fio = "";

            cal = new GregorianCalendar(Integer.parseInt(in[in.length-1]),
                                        Integer.parseInt(in[in.length-2])-1,
                                        Integer.parseInt(in[in.length-3]));

            for (int i = 0; i < in.length - 3 ; i++) {
                fio = fio + in[i] + (i < in.length-4?" ":"") ;
            }

            PEOPLE.add(new Person(fio, cal.getTime()));
        }
            fr.close();
    }

}

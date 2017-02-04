package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) { this.scanner = scanner; }

        @Override
        public Person read()  {
            String[] parsString;
            String inString = null;
            if(scanner.hasNext()) { inString = scanner.nextLine();}
            parsString = inString.split(" ");

            Calendar cal = new GregorianCalendar(Integer.parseInt(parsString[5]),
                                          Integer.parseInt(parsString[4])-1,
                                                  Integer.parseInt(parsString[3]));

            return new Person(parsString[1],
                              parsString[2],
                              parsString[0],
                              cal.getTime());
        }

        @Override
        public void close() throws IOException {
            this.scanner.close();
        }
    }
}

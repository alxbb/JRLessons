package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Contact, Customer{
        private IncomeData incomeData;
        private String parsePhone(int cCode, int number){
            String tmp = String.format("%010d",number);
            return String.format("+%s(%3.3s)%3.3s-%2.2s-%2.2s",
                    cCode,
                    tmp.substring(0,3),
                    tmp.substring(3,6),
                    tmp.substring(6,8),
                    tmp.substring(8));
        }

        public IncomeDataAdapter(IncomeData incomeData) { this.incomeData = incomeData; }

        @Override
        public String getCompanyName() { return this.incomeData.getCompany(); }

        @Override
        public String getCountryName() { return countries.get(this.incomeData.getCountryCode()); }

        @Override
        public String getName() {
            return String.format("%s, %s", this.incomeData.getContactLastName(), this.incomeData.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            return parsePhone(this.incomeData.getCountryPhoneCode(),
                              this.incomeData.getPhoneNumber());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
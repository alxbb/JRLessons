package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Иванов1","Вася");
        hm.put("Иванов2","Ваня");
        hm.put("Иванов3","Валя");
        hm.put("Иванов4","Варя");
        hm.put("Иванов5","Важа");
        hm.put("Иванова6","Вася");
        hm.put("Иванова7","Ваня");
        hm.put("Иванова8","Валя");
        hm.put("Иванова9","Варя");
        hm.put("Иванова10","Важа");
        return hm;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int matches=0;
        for( Map.Entry<String, String> pair : map.entrySet() ){
            if (pair.getValue().equals(name)) matches++;
        }
        return matches;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int matches=0;
        for( Map.Entry<String, String> pair : map.entrySet() ){
            if (pair.getKey().equals(lastName)) matches++;
        }
        return matches;

    }
}

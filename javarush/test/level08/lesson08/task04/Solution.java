package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
//    public static void main(String[] args)
//    {
//        System.out.println("Step 1:");
//        HashMap<String,Date> mp = createMap();
//        for (Map.Entry<String, Date> pair : mp.entrySet())
//            System.out.println(pair.getValue() + "\t" + pair.getKey());
//
//        removeAllSummerPeople(mp);
//
//        System.out.println("Step 2:");
//        for (Map.Entry<String, Date> pair : mp.entrySet())
//            System.out.println(pair.getValue() + "\t\t " + pair.getKey());
//    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stradivari", new Date("JANUARY 1 1980"));
        map.put("Stanford", new Date("FEBRUARY 1 1980"));
        map.put("Stark", new Date("MARCH 1 1980"));
        map.put("Stalin", new Date("APRIL 1 1980"));
        map.put("Stallkin", new Date("MAY 1 1980"));
        map.put("Stallotte", new Date("JUNE 1 1980"));
        map.put("Stallonom", new Date("JULY 1 1980"));
        map.put("Stallone", new Date("AUGUST 1 1980"));
        map.put("Stallonen", new Date("SEPTEMBER 1 1980"));
        map.put("Stallonene", new Date("OCTOBER 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Date> item = it.next();
            int month = item.getValue().getMonth();
            if (month >= 5 && month <= 7){
                it.remove();
            }
        }

    }
}

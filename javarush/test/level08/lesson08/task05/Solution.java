package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Иванов","Ваня");
        map.put("Петров","Леша");
        map.put("Сидоров","Иван");
        map.put("Жмых","Леша");
        map.put("Каков","Иван");
        map.put("Пыжов","Иван");
        map.put("Тупов","Петр");
        map.put("Чумнов","Иван");
        map.put("Драчун","Петро");
        map.put("Скакун","Иван");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        Set<String> names = new HashSet<String>();
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : map.entrySet()) {
            names.add(pair.getValue());
        }

        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String name = it.next();
            int count = 0;
            for (Map.Entry<String, String> pair : copy.entrySet()) {
                if (pair.getValue().equals(name)) count++;
                if (count > 1) removeItemFromMapByValue(map, name);
            }

        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}

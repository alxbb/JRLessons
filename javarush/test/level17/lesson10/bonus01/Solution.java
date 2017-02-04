package com.javarush.test.level17.lesson10.bonus01;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        if(args.length < 2 || args.length > 5)return;
        if( "-d".equals(args[0])){                                   // удаление
            allPeople.get((int)Integer.parseInt(args[1])).setName(null);
            allPeople.get((int)Integer.parseInt(args[1])).setSex(null);
            allPeople.get((int)Integer.parseInt(args[1])).setBirthDay(null);
        } else if( "-i".equals(args[0])){                           // информация
            Sex s = allPeople.get((int)Integer.parseInt(args[1])).getSex();
            String sex="";
            if ( s == Sex.MALE ) sex = "м";
            if ( s == Sex.FEMALE ) sex = "ж";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String bd = sdf.format(allPeople.get((int)Integer.parseInt(args[1])).getBirthDay());
            System.out.println(allPeople.get((int)Integer.parseInt(args[1])).getName() + " " + sex + " " + bd);

        } else if( "-u".equals(args[0])){                           // обновление
            System.out.println(allPeople.get(Integer.parseInt(args[1])));
            allPeople.get((int)Integer.parseInt(args[1])).setName(args[2]);
            if("м".equals(args[3])) allPeople.get((int)Integer.parseInt(args[1])).setSex(Sex.MALE);
            if("ж".equals(args[3])) allPeople.get((int)Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            Date bd = new Date(args[4]);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            allPeople.get((int)Integer.parseInt(args[1])).setBirthDay( sdf.parse(args[4]));
        } else if("-c".equals(args[0])){                            // новый
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            if("м".equals(args[2])) allPeople.add(Person.createMale(args[1], sdf.parse(args[3])));
            if("ж".equals(args[2])) allPeople.add(Person.createFemale(args[1], sdf.parse(args[3])));
            System.out.println(allPeople.size()-1);
        }
    }
}

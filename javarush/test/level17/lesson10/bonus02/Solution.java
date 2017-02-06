package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if(args.length < 2) return;

        String action = args[0];
        synchronized (allPeople){
            if("-d".equals(action)){
                for (int i = 1; i < args.length; i++) {
                    int idx = Integer.parseInt(args[i]);
                    allPeople.get(idx).setName(null);
                    allPeople.get(idx).setSex(null);
                    allPeople.get(idx).setBirthDay(new Date());
                }
            }else if("-i".equals(action)){
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String sex;
                for (int i = 1; i < args.length; i++) {
                    int idx = Integer.parseInt(args[i]);
                    Sex s = allPeople.get(idx).getSex();
                    sex = (s==Sex.MALE?"м":(s==Sex.FEMALE?"ж":""));
                    System.out.println( allPeople.get(idx).getName() + " " +
                                        sex + " " +
                                        sdf.format(allPeople.get(idx).getBirthDay()));
                }
            }else if("-c".equals(action)){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
                int rpt=(args.length-1)/3;
                for (int i = 0; i < rpt ; i++) {
                    int next = 3*i;
                    if("м".equals(args[next+2])) allPeople.add(Person.createMale(args[next+1], sdf.parse(args[next+3])));
                    if("ж".equals(args[next+2])) allPeople.add(Person.createFemale(args[next+1], sdf.parse(args[next+3])));
                    System.out.println(allPeople.size()-1);
                }
            }else if("-u".equals(action)){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
                int rpt=(args.length-1)/4;
                for (int i = 0; i < rpt ; i++) {
                    int next = 4*i;
                    int idx = Integer.parseInt(args[next+1]);
                    allPeople.get(idx).setName(args[next+2]);
                    allPeople.get(idx).setBirthDay(sdf.parse(args[next+4]));
                    if("м".equals(args[next+3])) allPeople.get(idx).setSex(Sex.MALE);
                    if("ж".equals(args[next+3])) allPeople.get(idx).setSex(Sex.FEMALE);
                }
            }
        }
    }
}

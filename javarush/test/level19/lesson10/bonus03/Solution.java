package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length==0)return;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fName = "C:\\Temp\\index.html";// br.readLine();
        br.close();
        long fSize = new File(fName).length();
        char[] buf = new char[(int) fSize];

        FileReader fr = new FileReader(fName);
        fr.read(buf);
        fr.close();
        String result="";

        for (int i = 0; i < buf.length; i++) {
            if(buf[i] == 10 || buf[i] == 13) continue;
            result = result + buf[i];
        }
        String pat = "(<span.*?>)(\\w*)(?:\\s+<span>\\s+<\\/span>\\s+<\\/span>\\s+<span>\\s+)?(<\\/span>)";
        String pat1 = "<" + args[0] + ">" + ".*?" + "</" + args[0] + ">";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(result);
        while(matcher.find()){
            System.out.println(matcher.group());
        }

//        System.out.println(result);

    }
}

//<html>
//<head>
//<title> JavaRush lesson 19 test </title>
//</head>
//<body>
//<hr>
//<H1> Hello World <H1>
//Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
//</sPan></b></span><span>Super</span><sPAn>girl</span>
//</body>
//</html>
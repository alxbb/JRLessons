package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    private FileOutputStream fos;

    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName);
        this.fos = fos;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException {this.fos.write(b);}

    @Override
    public void write(byte[] b) throws IOException {this.fos.write(b);}

    @Override
    public void write(byte[] b, int off, int len) throws IOException {this.fos.write(b, off, len);}

    @Override
    public void close() throws IOException {
        this.fos.flush();
        this.fos.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        this.fos.close();
    }

    @Override
    public FileChannel getChannel() {
        return this.fos.getChannel();
    }

}


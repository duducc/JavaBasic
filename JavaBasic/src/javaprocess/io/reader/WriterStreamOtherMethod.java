package javaprocess.io.reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流写数据的其他方法：
 *       void  write(char[] cbuf)  写入字符数组
 *       void  write(char[] cbuf,int offset,int len)  写入字符数组的某一部分，off数组的开始索引，len写的字符个数
 *       void write(String str) 写入字符串
 *       void write(String str) 写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 */
public class WriterStreamOtherMethod {
    public static void main(String[] args) throws IOException{
        FileWriter fw = new FileWriter("D:\\workspace\\Devlop\\e.txt");
        char[] cs = {'a','b','c','d'};
        //void  write(char[] cbuf)  写入字符数组
        fw.write(cs);//abcd

        //void  write(char[] cbuf,int offset,int len)  写入字符数组的某一部分，off数组的开始索引，len写的字符个数
        fw.write(cs,1,2);//abcd

        // void write(String str) 写入字符串
        fw.write("刺激战场");

        //void write(String str) 写入字符串的某一部分，off字符串的开始索引，len写的字符个数
        fw.write("大吉大利，今晚吃鸡",4,2);


        fw.close();
    }
}

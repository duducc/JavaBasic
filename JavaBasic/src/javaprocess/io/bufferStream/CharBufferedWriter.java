package javaprocess.io.bufferStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * java.io.BufferedWriter extends Writer  所以它是一个字符流
 *   BufferedWriter:字符缓冲输出流
 *
 *   继承自父类的成员方法：
 *     //。。。
 *
 *    构造方法：
 *       BufferedWriter(Writer out)
 *       BufferedWriter(Writer out,int sz)
 *   参数:
 *       Writer out :字符输出流
 *           我们可以传递FileWriter,缓冲流会给FileWriter增加一个缓冲区，提高FileWriter的写入效率
 *       int sz :指定缓冲区的大小，不写默认大小
 *   特有的成员方法
 *       void  newLine()   写入一个行分隔符。会根据不同的操作系统，获取不同的行分隔符
 *
 *    使用步骤：
 *       1.创建字符缓冲输出流对象，构造方法种传递字符输出流
 *       2.调用字符缓冲输出流中的方法write ，把数据写入到内存缓冲区
 *       3.调用字符缓冲输出流中的方法flush ，把字符缓冲区中的数据，刷新到文件中
 *       4.释放资源
 *
 *
 */
public class CharBufferedWriter {
    public static void main(String[] args) throws IOException{
        //1.
        FileWriter fw = new FileWriter("D:\\workspace\\Devlop\\j.txt");
        //2.
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < 10; i++) {

            bw.write("和平精英");
           // bw.write("\r\n");
            // 使用特有方法换行
            bw.newLine();
            //并且我们一开始学习的输出语句  println()方法  里面调用的就是newLine()方法

        }
        //3.
        bw.flush();

        //4.
        bw.close();


    }
}

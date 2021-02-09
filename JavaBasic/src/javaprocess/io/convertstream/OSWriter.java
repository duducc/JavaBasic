package javaprocess.io.convertstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *OSWriter 写的转换流  它既然是以Writer结尾的  那说明它就是一个字符流
 * java.io.OSWriter extends Writer
 *   是字符通向字节的桥梁  把字符给他转换为字节  它可以使用指定的 charset 将要写入流的字符编码成字节（编码）

 *   继承自父类的共性成员方法：
 *       //。。。
 *     OSWriter(OutputStream out)    创建使用默认字符编码的 OSWriter。
 *     OSWriter(OutputStream out, String charsetName)   创建使用指定字符集的 OSWriter。
 *
 *     OutputStream out ：字节输出流可以用来写转换之后的字节到文件中  转化流将字符转换为字节  由谁来写由它来写
 *     String charsetName： 指定的编码表名称，不区分大小写，可以是utf-8/UTF-8,GBK/gbk  。。。。  不指定默认使用UTF-8  IDE的默认编码
 *
 *     使用步骤：
 *       1.创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码名称
 *       2.使用OutputStreamWriter对象中的方法write,把字符转换为字节存储到缓冲区中    实际上这就是一个(编码)的过程
 *       3.使用OutputStreamWriter对象中的方法flush，把内存缓冲区中的字节刷新到文件中 实际上这就是使用字节流 写字节的过程
 *       4.释放资源
 *
 *
 */
public class OSWriter {
    public static void main(String[] args) throws IOException {
        write_utf_8();
    }

    /**
     * 使用转换流OutputStreamWriter写UTF-8格式的文件
     */
    private static void write_utf_8() throws IOException {
        //1.
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\workspace\\Devlop\\z.txt"),"UTF-8");
        //2.
        osw.write("你好");
        //3.
        osw.flush();
        //4.
        osw.close();

    }
}

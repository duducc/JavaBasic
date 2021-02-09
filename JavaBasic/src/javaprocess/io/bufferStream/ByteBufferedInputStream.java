package javaprocess.io.bufferStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  java.io.BufferedInputStream  extends  InputStream
 *  BufferedInputStream : 字节缓冲输入流
 *
 *   继承自父类的成员方法：
 *     //。。  同字节缓冲输出流
 *
 *   构造方法：
 *    //。。  格式同字节缓冲输出流  与之类似
 *
 *    使用步骤(重点)
 *           与字节缓冲输出流类似
 */

public class ByteBufferedInputStream {


    public static void main(String[] args) throws IOException{
        FileInputStream fis  = new FileInputStream("D:\\workspace\\Devlop\\b.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);

        //接下来调用read进行读取  读取的过程还是一样的 我们可以让他一次读取一个字节

        //int  read()从输入流中读取数据的下一个字节

        int  len = 0;//记录每次读取到的字节

        while((len = bis.read())!=-1){
            System.out.println(len);
        }


        //使用第二种方法也可以读取 它的效率会更高
        byte[]  bytes = new byte[1024];//存储每次读取的数据
        int len2=0;//记录每次读取的有效字节个数
        while ((len2=bis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len2));

        }




        bis.close();//注意：   还是bis.close()   这资源释放 我们只要关闭缓冲流就可以了 不用关闭这个基本的字节流
                    //                           因为一关闭这个缓冲流  它就会自动把这个基本流给它关闭了  字节缓冲输出流也是一样的 直接关闭缓冲流就可以了
                    //  读取到的结果是一堆的字节  因为这个UTF8占用3个字节

    }
}

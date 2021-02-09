package javaprocess.io.bytestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * package：java.io
 * 字节输出流：
 *    OutputStream   是一个抽象类  这个流是所以字节输出流的一个最顶层的父类  它上面直接是Object
 *
 *    定义了一些子类共性的成员方法：
 *    public void close():关闭此输出流并释放与此流相关联的任何系统资源。
 *    public void flush():刷新此输出流并强制任何缓冲的输出字节被写出。
 *    public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流。
 *    public void write(byte[] b，int off,  int len):从指定的字节数组写入len字节，从偏移量off开始输出到此输出流。
 *    public void write(int b):将指定的字节输出流。
 *
 *    直接已知子类--前面定义流的功能 后面定义的是父类也就是我这个子类它用的哪个父类
 *          ByteArrayOutputStream  往字节数组里面写数据的一个字节输出流
 *          FileOutputStream       往文件中写数据的一个字节输出流
 *          FilterOutputStream     带过滤器的字节输出流
 *          ObjectOutputStream     用于写对象的字节输出流
 *          OutputStream           其他包中的流  跟我们这个没什么关系
 *          PipedOutputStream      管道流
 *    java.io.FileOutputStream extends OutputStream
 *
 *    FileOutputStream:文件字节输出流  --那我这个流主要用于往文件中写数据的
 *          作用：把内存中的数据写入到硬盘的文件中

 *       构造方法： 都是创建FileOutputStream对象
 *          FileOutputStream(Stream name)  //创建一个向指定名称的文件中写入数据的输出文件流
 *          FileOutputStream(File file)    //创建一个向指定File对象表示文件中写入数据的文件输出流
 *
 *          参数：写入数据的目的地
 *          Stream name： 目的地是一个文件的路径  给我一个路径我往这个文件中写
 *          File file：目的地是一个文件 我直接往这个文件中写数据
 *
 *          构造方法的作用：
 *             1.创建一个FileOutputStream对象
 *             2.会根据构造方法中传递的文件/文件路径，创建一个空的文件--带创建文件的功能
 *             3.会把FileOutputStream对象指向创建好的文件
 *
 *             接下来我们看一下 怎么把数据从内存中写入到硬盘中
 *
 *             写入数据的原理(内存-->原理)
 *               java程序-->JVM(java虚拟机)-->OS(操作系统)-->OS调用写数据的方法-->把数据写入到文件中
 *                                                           所以不是我们这个IO流直接把数据写入到文件中去的
 *                                                           我们没有权限来操作windows系统而是由上面的顺序完成的
 *         字节输出流的使用步骤(重点)
 *              1.创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
 *              2.调用FileOutputStream对象中的方法write，把数据写入到文件中
 *              3.释放资源  （因为流在使用的过程中我们占用了一部分系统资源   我创建这个程序一执行，它是不是会跑到内存中，
 *                            我们是不是还调用了一部分系统相关的资源  这些资源我们最后使用完毕都要给他释放掉
 *                            释放掉这样可以节约内存  我们程序的效率高
 *                            ）
 *                            （流使用会占用一定的内存，使用完毕要把内存清空，提供程序的效率）
 *
 *
 */
public class ByteOutputStream {
    public static void main(String[] args) throws IOException {

        //1.创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
        FileOutputStream fos = new FileOutputStream("D:\\workspace\\Devlop\\a.txt");

        //2.调用FileOutputStream对象中的方法write，把数据写入到文件中
        //public void write(int b):将指定的字节输出流。
        fos.write(97);

        //3.释放资源
        fos.close();

        /**
         * 写数据的时候，会把10进制的整数97，转换为二进制整数97 因为我们硬盘是不是只能存储二进制数据
         * 所以在上面 fos.write(97)  它实际上写的不是97 而是写的是它的二进制数据  那97 转换成二进制的数据是  1100001   97-->1100001
         * 所以这就是二进制的97  所以我要写这个数据它实际上存的不是97 而是97的二进制数据1100001
         * 硬盘中存储的数据都是字节
         * 1个字节=8个比特位(10101010)   实际上我们写完之后这个数据是以二进制形式保存在文件中
         *
         * 任意的文本编辑器(记事本，notepad++ ....)
         * 在打开文件的时候，都会查询编码表，把字节转换为字符表示 方便我们阅读
         * 0-127：查询ASCII表
         *
         *     97--->a
         *
         * 其他值：查询系统默认码表(中文系统GBK)
         */



        /**
         * 一次写多个字节的方法：
         *
         *  public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流。
         *  public void write(byte[] b，int off,  int len):从指定的字节数组写入len字节，从偏移量off开始输出到此输出流。
         *
         *
         */

        //1.创建FileOutputStream对象，构造方法中传递写入数据的目的地
        FileOutputStream fos2 = new FileOutputStream(new File("D:\\workspace\\Devlop\\b.txt"));
        //调用FileOutputStream对象中的方法write，把数据写入到文件中
        //在文件中显示100  写3个字节
        fos2.write(49);
        fos2.write(48);
        fos2.write(48);

        //public void write(byte[] b):将b.length字节从指定的字节数组写入此输出流。
        //一次写多个字节：
                //如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
                //如果写的第一个字节是负数，那第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认码表(GBK)

        byte[] bytes = {65,66,67,68,69};//ABCDE  是不是查询的ASCII表
        //byte[] bytes = {-65,-66,-67,68,69};//烤紻E

        fos2.write(bytes);


        //写字节数组的一部分
              //public void write(byte[] b，int off,  int len):  把字节数组的一部分写入到文件中
                      //从指定的字节数组写入len字节，从偏移量off开始输出到此输出流。
                      //int off ：开始索引  数组的开始索引
                      //int len ：写几个字节
        fos2.write(bytes,1,2);//BC

        //写入字符的方法：可以使用String类中的方法把字符串，转换为字节数组
          //byte[]  getBytes()  把字符串转换为字节数组

        byte[] bytes2 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes2));//[-28, -67, -96, -27, -91, -67]
        fos2.write(bytes2);//所以这也是写字节  那这个你好是不是4个字节  你：2个  好：2个

        //utf-8 三个字节是一个中文
        //GBK   两个字节是一个中文


        //释放资源
        fos2.close();

        /**
         * 数据的追加写和续写
         *    如果我把上面的代码再运行一次 它是再创建一个文件 然后把数据重新写一次，相当于覆盖写  就会把之前的文件给他覆盖掉了
         *    它并不是往这个文件后面继续写数据
         *    下面就来看一下怎么让它往这个文件的后面继续写数据  并且在写数据的同时让它进行一个换行
         *
         * 追加写/续写：使用两个参数的构造方法
         *    FileOutputStream(String name,boolean append)创建一个向具有指定name的文件中写入数据的输出文件流。
         *    FileOutputStream(File   file,boolean append)创建一个向指定File对象表示的文件中写入数据的输出文件流。
         *    参数：
         *      String name，File file： 写入数据的目的地
         *      Boolean  append：追加写开关
         *      true：创建对象不会覆盖源文件，继续在文件的末尾追加写数据
         *      false:创建一个新文件，覆盖源文件
         *
         *
         *  写换行：写换行符号
         *   windows ： \r\n
         *      linux:  /n
         *        mac:  /r
         *
         */
        FileOutputStream fos3 = new FileOutputStream("D:\\workspace\\Devlop\\c.txt",true);

        for (int i = 0; i <10 ; i++) {

            fos3.write("你好".getBytes());//这样并不会换行

            //写换行符号
            fos3.write("\r\n".getBytes());
        }

        fos3.close();


    }



}

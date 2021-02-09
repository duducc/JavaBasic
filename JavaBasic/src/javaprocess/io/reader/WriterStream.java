package javaprocess.io.reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 *java.io.Writer:字符输出流，是所有字符输出流的最顶层的父类  是一个抽象类
 *   共性的成员方法
 *     void  write(int c)  写入单个字符
 *     void  write(char[] cbuf)  写入字符数组
 *     abstract void  write(char[] cbuf,int offset,int len)  写入字符数组的某一部分，off数组的开始索引，len写的字符个数
 *     void write(String str) 写入字符串
 *     void write(String str) 写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 *     void flush()  刷新该流的缓冲
 *     void close()  关闭此流 但要先刷新它
 *
 *     抽象类我们无法使用  所以说我们得使用它得子类
 *     子类命名规则    ：子类功能+父类名称
 *     BufferWriter  带缓冲
 *     CharArrayWriter  字符数组的
 *     FilterWriter  带过滤器的
 *     OSWriter  之后要学的转换流
 *     PipedWriter   管道流
 *     PrintWriter
 *     StringWriter  写字符串的这么一个流
 *
 *
 *     OSWriter  下面有一个子类  FileWriter  往文件中写字符的流
 *
 *     java.io.FileWriter extends  OSWriter  extends  Writer
 *
 *     FileWriter:文件字符输出流
 *     作用：把内存中字符数据写入到文件中
 *
 *     构造方法：
 *      FileWriter(File file)  根据给定的 File 对象构造一个 FileWriter 对象。
 *      FileWriter(String fileName) 根据给定的文件名构造一个 FileWriter 对象。
 *
 *      参数：写入数据的目的地
 *          String fileName 文件的路径
 *          File file 是一个文件
 *
 *
 *
 *      构造方法的作用：
 *            1.创建一个FileWriter对象
 *            2.会根据构造方法中传递的文件/文件的路径  创建(一个)文件
 *            3.会把FileWriter对象指向创建好的文件
 *
 *     字符输出流的使用步骤(重点)：
 *           1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
 *           2.使用FileWriter中的方法write,把数据写入到内存到内存缓冲区中
 *                                         （这块有一个转换的过程   字符转换为字符的过程）
 *                                          咱们之前说过我们计算机中存储的是不是都是字节
 *                                          但是我现在写的可是字符啊 所以说它实际上在内存中
 *                                          有一个把字符转换为字符的过程
 *           3.使用FileWriter中的方法flush，把内存缓冲区中的数据，刷新到文件中
 *           4.释放资源(它会先把内存缓冲区中的数据刷新到文件中 所以说第三步flush()可以不用写)
 *
 *           这个字符流跟字节流使用的最大区别：
 *                字符流它不是直接把数据写入到文件中
 *                它是写入到内存中去
 *
 *
 *
 *
 *
 *
 *    flush与close()区别 ：
 *     1.flush：刷新缓冲区，流对象可以继续使用。
 *     2.close：先刷新缓冲区，然后通知系统释放资源，流对象不可以再被使用了。
 *                close方法之后流已经关闭了，已经从内存中消失了，流就不能再使用了
 *                再调用close方法之后 若再使用流对象fw 会抛出IOException：Stream closed
 *
 *
 *    字符输出流写数据的其他方法：
 *       void  write(char[] cbuf)  写入字符数组
 *       void  write(char[] cbuf,int offset,int len)  写入字符数组的某一部分，off数组的开始索引，len写的字符个数
 *       void write(String str) 写入字符串
 *       void write(String str) 写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 *
 *
 */
public class WriterStream {
    public static void main(String[] args) throws IOException{

        //1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
        FileWriter fw = new FileWriter("D:\\workspace\\Devlop\\d.txt");

        //2.使用FileWriter中的方法write,把数据写入到内存到内存缓冲区中
        //void  write(int c)  写入单个字符
        fw.write(97);
        /**
         * 注意：
         *   在前面的字节输出流当中  假设写了一个97   我最后我并不释放资源(即没有调用close()方法)
         *   我也没有调用什么flush()方法  这个时候执行一下代码 让他写一遍  发现该文件中已经写入 a 了
         *   因为这里边我们写的是什么东西  我们写的是  字节数据  它是直接写入到硬盘的文件中去的
         *
         *
         *   而这个字符流就不是了  同样也是按照上面的代码格式(没有调用close()，flush()方法 )来写
         *   写完之后发现  里面有没有数据 是不是没有数据
         *   所以说 字符流是把数据写入到内存缓冲区中  这边有个把字符转换为字节的过程
         *   如果你没有调用 flush() 或 close()方法  那么这个数据是不会由内存中写入到硬盘中去的
         *   而我这个程序一停止这个数据就消失了
         */

        //所以我们在这里边要调用一下这个flush()的方法必须把这个数据给它刷新过去  再执行代码发现数据已经被成功写入
        //3.使用FileWriter中的方法flush，把内存缓冲区中的数据，刷新到文件中
        fw.flush();

        //4.释放资源(它会先把内存缓冲区中的数据刷新到文件中 所以说第三步flush()可以不用写)
        fw.close();//即使没有再这之前调用flush()方法    close()方法也会把内存缓冲区中的数据刷新到文件中


    }

}

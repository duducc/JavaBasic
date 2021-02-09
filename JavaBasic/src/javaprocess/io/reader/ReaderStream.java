package javaprocess.io.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 由使用字节流读取中文会产生乱码
 * 因次java提供了一个字符流 使用字符流它可以用来读写字符
 * 字节流一次读写一个字节 而字符流呢就可以一次读写一个字符
 * 不管你的字符是中文的还是英文的 还是数字的  还是符号  使用它都可以进行读写
 *
 * java.io.Reader:字符输入流，是字符输入流最顶层的父类 里面定义了一些共性的成员方法  它是一个抽象类
 *   共性的成员方法：
 *     int  read(); 读取单个字符并返回
 *     int  read(char[] cbuf); 一次读取多个字符，将字符读入数组。
 *     close(); 关闭流并释放与之有关联的所有资源
 *
 *     抽象类我们无法使用  所以说我们得使用它得子类
 *     子类命名规则    ：子类功能+父类名称
 *     BufferReader  带缓冲
 *     CharArrayReader  字符数组的
 *     FilterReader  带过滤器的
 *     InputStreamReader  之后要学的转换流
 *     PipedReader   管道流
 *     StringReader  读取字符串的这么一个流
 *
 *     //以后只要看见它是以Reader 或者Writer结尾的 它就是一个字符流
 *     //以InputStream 或者OutputStream结尾的 它就是一个字节流
 *
 *     //现在学习一下  InputStreamReader下面的一个子类 FileReader  读取文件的字符输入流
 *
 *     java.io.FileReder extends  InputStreamReader extends Reader
 *
 *     FileReader:文件字符输入流
 *     作用：把硬盘文件中的数据以字符的方式读取到内存中
 *
 *     构造方法：
 *        FileReader(String fileName)
 *        FileReader(File file)
 *          参数：读取文件的数据源
 *                 String fileName：文件的路径
 *                 File file ；一个文件
 *        FileReader构造方法的作用：
 *            1.创建一个FileReader对象
 *            2.会把FileReader对象指向要读取的文件
 *
 *     字符输入流的使用步骤：
 *         1.创建FileReader对象，构造方法中绑定要读取的数据源
 *         2.使用FileReader对象中的方法read读取文件
 *         3.释放资源
 *
 *         流的使用步骤是一样的和  和字节流的使用是一样的
 *
 *
 */
public class ReaderStream {
    public static void main(String[] args) throws IOException {
        //1.创建FileReader对象，构造方法中绑定要读取的数据源
        FileReader fr = new FileReader("D:\\workspace\\Devlop\\c.txt");

        //2.使用FileReader对象中的方法read读取文件
        //int  read(); 读取单个字符并返回
        //此处省去多段相同代码与前面类似  直接使用while
        int len = 0;
       // while((len = fr.read())!=-1){
            //System.out.println(len);//结果是一堆整数  原因：因为把这个字符给它转成int类型的整数了
            //System.out.print((char) len);//可以强转给它转成char类型
            //使用了字符流之后  会发现 不管问你的文件里面是中文还是英文还是数字 都可以读取出来 因为我是按照一个一个字符来读的
        //}

        System.out.println("=======================");

        //int  read(char[] cbuf); 一次读取多个字符，将字符读入数组。
        char[] chars = new char[1024];//用来存储读取到的多个字符
        int len2 = 0;//记录的是每次有效读取的字符个数
        while((len2=fr.read(chars))!=-1){

            /**
             * String类的构造方法
             * String(char[] value)  把字符数组转换为字符串
             * String(char[] value,int offset,int count)  把字符数组的一部分转换为字符串  offset  数组的开始索引  count 转换的个数
             *
             */
            System.out.println(new String(chars,0,len2));
            System.out.println(len2);

            //会发现和那个字节流是一样的  只是它俩读的内容不一样
            //字节流每次读取一个字节  而字符流每次读取一个字符（不管是中文 还是英文  还是符号  我每次都读取一个字符 但是使用方式是一样的）

        }


        fr.close();


    }


}

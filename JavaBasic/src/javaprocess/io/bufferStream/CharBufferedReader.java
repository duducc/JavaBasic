package javaprocess.io.bufferStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * java.io.BufferedReader extends Reader
 *
 *  继承自父类的成员方法：
 *    //。。。类似 同字符缓冲输出流
 *  构造方法：
 *     1.
 *     2.
 *     同字符缓冲输出流
 *     参数：
 *       同字符缓冲输出流
 *   特有的成员方法：
 *     String readLine() 读取一个文本行。读取一行数据
 *       行的终止符号：怎么认定是一行数据呢？ 通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行(\r\n)。
 *      返回值：包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
 *
 */
public class CharBufferedReader {
    public static void main(String[] args) throws IOException {
        //1.创建字符缓冲输入流对象，构造方法中传递字符输入流
        BufferedReader bw = new BufferedReader(new FileReader("D:\\workspace\\Devlop\\b.txt"));
        //2.使用字符缓冲输入流对象中的方法read/readLine读取文本
        //read方法不讲  前面已经用过很多次了 和之前使用的方法完全一模一样  重点来说readLine()方法
        String line = bw.readLine();
        System.out.println(line);

        line = bw.readLine();
        System.out.println(line);

        line = bw.readLine();
        System.out.println(line);

        line = bw.readLine();
        System.out.println(line);

        /**
         * 发现以上读取是一个重复的过程，所以可以使用循环优化
         * 不知道文件中有多少行数据，所以使用while循环
         * while的结束条件，读取到null的时候结束
         *
         */
        String line2;
        while ((line2=bw.readLine())!=null){
            System.out.println(line2);
        }

        //3.释放资源
        bw.close();
    }
}

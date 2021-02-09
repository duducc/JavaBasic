package javaprocess.io.bufferStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *缓冲流 也叫高效流  按照数据类型分类：
 *       字节缓冲流：BufferedInputStream   BufferedOutputStream
 *       字符缓冲流: BufferedReader    BufferedWriter
 *
 *
 *   java.io.BufferedOutputStream  extends OutputStream
 *       BufferedOutputStream :字节缓冲输出流
 *
 *       继承自父类的共性成员方法：
 *           //。。。  表示父类OutputStream 中的方法  当然在子类中也可以使用
 *
 *
 *      狗造方法：
 *        BufferedOutputStream(OutputStream out)   创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
 *        BufferedOutputStream(OutputStream out, int size)   创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
 *
 *         参数：
 *           OutputStream  out  字节输出流
 *             我们可以传递FileOutputStream,缓冲流会给FileOutputStream增加一个缓冲区，
 *             提高FileOutputStream的写入效率 这是这个缓冲流的作用
 *
 *          int size  指定缓冲流内部缓冲区的大小，不指定就是默认的大小
 *                    如果使用第一个(包含一个参数)构造方法 创建对象  它用的是这个内部的默认的缓冲的数组大小
 *                    第二个参数  我们可以指定它数组的大小
 *
 *      使用步骤(重点)
 *         我这个缓冲流里边既然让你给我传一个字节输出流 是不是为了提高它的效率
 *         1.创建一个字节输出流 例 FileOutputStream对象，构造方法中绑定我们要输出的目的地
 *         2.创建BufferedOutputStream对象,构造方法中传递FileOutputStream对象，提高FileOutputStream对象效率
 *         3.使用BufferedOutputStream对象中的方法write,把数据写入到内部缓冲区中 这回可不是把这数据写入到文件中了 而是写入到内部的缓冲区中
 *         4.使用BufferedOutputStream对象中的方法flush，把内部缓冲区中的数据，刷新到文件中
 *         5.释放资源(会先调用flush方法刷新数据，第四步可以省略)
 */
public class ByteBufferedOutputStream {
    public static void main(String[] args) throws IOException {

        //1
        FileOutputStream fos = new FileOutputStream("D:\\workspace\\Devlop\\h.txt");

        //2.
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //3.
        bos.write("我把数据写入到内部缓冲区中".getBytes());

        //在上面的几步执行完毕之后 数据是没有被写入的 因为数据它是在内部缓冲区中
        //4.
        bos.flush();
        //5.
        bos.close();
    }
}

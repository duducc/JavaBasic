package javaprocess.io.encoded;

import java.io.FileReader;
import java.io.IOException;

/**
 * 编码引出的问题问题
 * 前面接绍的FileReader  读取项目中的文本文件  它可以读取我们IDEA默认编码格式的文件  那现在IDEA默认编码格式是UTF-8
 * 那注意了读取这种文件 它是没有任何问题的  但是如果我们使用FileReader让它来读取Windows系统默认的
 * 编码GBK编码  就会出现乱码问题  因为它只能读取系统默认编码
 *
 * FileReader可以读取IDE默认编码格式(UTF-8)的文件
 * FileReader读取系统默认编码(中文GBK)会产生乱码����
 *
 * 这就是FileReader 因为它只能读取我们IDE默认编码格式的文件
 * 那我就要想读取GBK编码的文件怎么办就需要学习后面的转换流
 *
 *
 * 检验方法  在系统中创建一个文本文件并写入中文以GBK编码保存 然后使用FileReader去读取
 *
 * 会发现出现了乱码  因为编码跟解码的方式不一样了
 *
 *
 */
public class Concept {


    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\workspace\\Devlop\\GBK.txt");
        int len = 0;
        while((len=fr.read())!=-1){
            //System.out.println(len);//一堆的数字21050 28608 25112 22330   这个注意了没给它转换成char类型  是不是字节就是一堆的数字  这是没有问题的
            System.out.println((char)len);//�等一堆的问号
        }
        fr.close();

    }
}

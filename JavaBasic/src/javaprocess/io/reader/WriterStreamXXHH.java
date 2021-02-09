package javaprocess.io.reader;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流的续写和换行
 *   续写,追加写:使用两个参数的构造方法就可以了
 *
 *   FileWriter(File file, boolean append)
 *   FileWriter(String fileName, boolean append)
 *   参数：
 *     String fileName,File file:写入数据的目的地
 *     boolean append:续写开关 true:不会创建新的文件覆盖源文件，可以续写；
 *                             false：创建新的文件覆盖源文件
 *   换行：换行符号
 *    windows ：\r\n
 *      Linux ：/n
 *        mac :/r
 */
public class WriterStreamXXHH {
    public static void main(String[] args) throws IOException {
       FileWriter fw = new FileWriter("D:\\workspace\\Devlop\\g.txt",true);
        for (int i = 0; i < 10; i++) {
            fw.write("吃鸡了"+i);//续写了  但是它换行了吗 没换行  再执行一次  会继续跟再后面写 没有换行
            fw.write("吃鸡了"+i+"\r\n");//续写+换行
        }
        fw.close();
    }

}

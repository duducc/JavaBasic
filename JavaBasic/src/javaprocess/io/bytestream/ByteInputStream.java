package javaprocess.io.bytestream;

import javabasic.var_study.VariableDifference;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节输入流：java.io.inputStream 最顶层父类（表示字节输入流的所有类的超类）   它本身也是以抽象类  里面定义的也是一些字节输入流共用的方法(定义所有子类共性的方法)
 *     共性方法：
 *        int read() 从输入流中读取数据的下一个字节
 *        int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
 *        void close() 关闭此输入流并释放与该流关联的所有系统资源
 *
 *    已知子类：
 *      AudioInputStream   音频相关的
 *      ByteArrayInputStream
 *      FileInputStream
 *      FilterInputStream
 *      InputStream
 *      ObjectInputStream
 *      PipedInputStream
 *      SequenceInputStream     操作队列的
 *      StringBufferInputStream  读取字符串缓冲区的  StringBuilder都是字符串缓冲区
 *
 *
 *      java.io.FileInputStream extends InputStream
 *      FileInputStream  (文件字节输入流) 用来读取文件的
 *      作用：把硬盘文件中的数据,读取到内存中使用
 *
 *      构造方法：
 *         FileInputStream(String name)
 *         FileInputStream(File file)
 *
 *         参数：读取文件的数据源
 *                 String name  ： 文件的路径
 *                 File  file  :   就是一个文件
 *                    可以给我一个文件的路径我来读取它
 *                    也可以直接给我一个文件我来读取它
 *        构造方法的作用：
 *           1.会创建一个FileInputStream对象
 *           2.会把FileInputStream对象指向构造方法中要读取的文件
 *
 *    读取数据的原理：
 *      java程序-->JVM(java虚拟机)-->OS(操作系统)-->OS调用写数据的方法-->读取文件
 *     字节输入流的使用步骤：
 *       1.使用FileInputStream对象,构造方法中绑定要读取的数据源
 *       2.使用FileInputStream对象中的方法read，读取文件
 *       3.释放资源  --流跟流相关的资源都给它释放掉了
 *
 *
 *
 *
 *
 */
public class ByteInputStream {
    public static void main(String[] args) throws IOException {
        //1.使用FileInputStream对象,构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\workspace\\Devlop\\a.txt");
        //2.使用FileInputStream对象中的方法read，读取文件
        //int read() 读取文件中的一个字节并返回，读取到文件的末尾返回-1   这个比较特殊  它读一次之后  它会把这个指针向后一位  然后让它读第二个字节
        //int len = fis.read(); //它返回的就是一个整数
        //System.out.println(len);//97  a 说文件中第一个不是a吗  a它变成整数就是97么  是不是读取出来了

        //是不是有其他的数据 我就让他再来读一次
       // len = fis.read(); //它返回的就是一个整数
       // System.out.println(len);//98  b

       // len = fis.read();
       // System.out.println(len);//99 c

       // len = fis.read();
       // System.out.println(len);//-1  读取完毕了

        //再读一次还是-1
        //len = fis.read();
        //System.out.println(len);//-1


        /**
         * 字节输入流一次读取一个字节的原理：
         *    一次读取一个字节
         *         在电脑的硬盘上有一个文件a.txt  这个文件中有3个数据 一个是  a  一个是 b  一个是 c    还有结束标记(一个看不到的windows结束标记)
         *         先创建了一个对象那个  然后把这个对象会指向我要读取的文件
         *         而且注意  它指向的是指向我们文件中的第一个字节（所以在这个里面它实际上是有一个指针的概念的
         *                                                       类似有一个箭头在指向文件的第一个字节
         *                                                       在a.txt文件中这个箭头指向的就是 a
         *                                                       ）
         *        然后下边咋们是不是用read()方法来读取了 注意这个read()它并不是直接来读这个文件
         *        它找谁  它找  它去找JVM去  JVM找OS  OS再调用它的方法来读取数据  所以说是这么一个过程  OS再让它读取这个数据来
         *        那看这里  我这个read()  我们说它叫做读取一个字节并返回  那所以说我读的第一个字节是谁  是不是a
         *        所以说把 a就给它读回来了  给OS --->给JVM--->再给我们的Java程序
         *        那读完a之后 注意了  这个read()方法 它比较特殊  读完之后这个指针会自动向后移一位  移到b这里来(下面来)
         *        那我这第二次再读 读的是不是就是b了  b又读出来了   是不是也给我们Java程序  读完之后这个指针又会向后移动一位 来读取谁 来读取c
         *        也是这么一层一层的返回 也是一样的
         *        读完c之后 注意了 那这个指针再向后移动一位  那是不是就要读取到这个结束标记了
         *        所以说就会把这个结束标记给操作系统  注意它是windows系统的结束标记  然后这个结束标记又往回给谁 给JVM
         *        还是一个结束标记  然后JVM给我们的是谁 是-1了  并不是一个windows系统的结束标记  因为这个JVM咋们装的也是windows系统的java虚拟机
         *        所以说jvm认识这个结束标记 它会给我们返回一个-1 所以说最后我们打印的结果是什么  -1
         *
         *        如果说以后这个文件要是在linux系统中放着  那就是linux系统的结束标记  最后也会给我们返回一个-1
         *
         *
         */


        /**
         * 发现以上读取文件是一个重复的过程，所以可以使用循环优化
         * 不知道文件中有多少字节，使用while循环
         * while循环结束条件，读取到-1的时候结束
         *
         * 它的这个循环的布尔(boolean)表达式 有三层含义在里面
         *   1.fis.read()  读取一个字节
         *   2.len=fis.read() 把读取到的字节赋值给变量len
         *   3.(len=fis.read())!=-1 判断变量len是否不等于-1
         *
         *   注意：
         *     我们这个为什么要这么写
         *      因为这个read()的方法  它会读完当前这个字节  会把里面的指针指向下一个字节
         *
         *      如果用第二种方式读取
         *
         *
         */
        //注意怎么写 我给它定义一个int 类型的len  让它等于0
        int len = 0;//让它记录读取到的字节
        //while循环怎么写  这是一个固定写法
        while((len=fis.read())!=-1){
            //System.out.println(len);//97  98  99
            //System.out.print(len); //979899
            System.out.print((char)len);  //abc  文件中存的是不是就是abc啊
        }
        System.out.println("\r");
        System.out.println("===========================");
        //第二种写法
        //弊端：
        while(fis.read()!=-1){  //先读了一个   97   下一次读的时候就是99
            //再读取的时候就变成第二个字节了
            //第二次循环的时候发现已经读取完毕了  返回-1
            System.out.println(fis.read());// 结果是  98   -1
            //所以说 必须用一个变量来接收我们读取的数据
        }

        /**
         * 字节输入流一次读取多个字节的方法：
         *  int  read(byte[] b)从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
         *  明确两件事情：
         *    1.方法的参数byte[]的作用？
         *        起到缓冲作用，存储每次读取到的多个字节
         *        数组的长度(刚才我们定义的是不是2啊)  一般定义为多少1024(1kb)或者是1024的整数倍
         *
         *    2.方法的返回值int是什么？
         *        每次读取的有效字节个数
         *
         *    String类的构造方法
         *       String(byte[] bytes):把字节数组转换为字符串
         *       String(byte[] bytes,int offset,int length):把字节数组的一部分转换为字符串 offset数组的开始索引 length转换的字符个数
         *
         *
         *
         */

        FileInputStream fis2 = new FileInputStream("D:\\workspace\\Devlop\\b.txt");//假设内容是ABCDE
        //使用FileInputStream对象中的read()方法读取文件
        //int  read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
        byte[] bytes = new byte[2];
        int len2 = fis.read(bytes);
        System.out.println(len2);//2
        //System.out.println(Arrays.toString(bytes));//[65,66]
        System.out.println(new String(bytes));//AB

        len2 = fis2.read(bytes);
        System.out.println(len2);//2
        System.out.println(new String(bytes));//CD

        len2 = fis2.read(bytes);
        System.out.println(len2);//1
        System.out.println(new String(bytes));//ED

        len2 = fis2.read(bytes);
        System.out.println(len2);//-1
        System.out.println(new String(bytes));//ED

       //代码执行原理
        // 在电脑的硬盘中存储了一个文件叫做b.txt里面的数据是ABCDE 结束标记
        //第一步同样创建了一个流对象  并且把这个对象指向了流要读取的文件
        //创建了一个数组 byte类型的数组  那就画一个数组 可以想象是一个长方形
        //注意这个数组的长度是2  长方形里面有2个格子  那我这个数组咋们说它的初始值是多少
        //初始值是不是0跟0啊  那整数的默认值不就是0吗  byte  int  short long  不都是0吗
        //索引分别是0和1
        //创建完这个数组 我是不是要读取数据了  读取数据还是和前面一样的  就不赘述了
        //刚开始读取的时候这个指针指向的还是第一个字节A  现在看怎么读   叫做第一次读取
        //它首先会读这个A  会把这个A给他读出来  读完这个A发现我这个数组里面还有一个位置
        //所以说它会继续把B给它读出来  所以第一次读取的内容就是A和B
        //会把A和B读出来之后  读出来之后那这个A和B就会把这个数组给占了 就不是这两个0 就是我们读取的A和B了
        //然后这个len它指的是什么意思  len就是我们读取的有效字节个数 所以说我第一读了几个 是不是读了两个 所以这个len它返回的是2
        //读完A  读完B  那它这个指针就应该指向谁去了  就指向C去了  指向C我让它再来第二次读取
        //第二次读取会读取C 然而我这个数组还有一个地方  它会把这个D也会给它读取出来  所以说读取的内容是C跟D  那读取的有效的几个个数 是不是也是2个
        //然后这个C跟D 它就会把这个A跟B给覆盖掉了  所以说一打印这个数组  他打印的是里面什么  读取了两个打印的是C跟D  这第二次读取
        //读完之后这个指针就会移动到E这块去  它就会移动到E这儿来  然后我再来第三次读取
        //它首先指向E我就读取E  然后读完E之后发现后面就是结束标记了 就没了  我就不读了 就读一个 所以说返回的有效个数是1
        //然后这个E会把谁 会把这个C给它覆盖掉  所以说在这里打印的len有效个数是1  打印这个数组它里面放的是谁E跟D 我只读了一个 这是第三次
        //读完第三次之后 那这个指针还会向后移动一位  移动到这个结束标记上去了
        //移动到这个结束标记上去 那我第四次读取  那它里面还有数据吗 没了 就不会读了  所以说没有读到数据它给你返回-1 哎说明没有读到数据
        //所以打印这个len是-1   打印这数组是因为没有读取到数据之前的数据没有被覆盖 所以仍然是E跟D
        //读到结束标记了 JVM给我们返回的还是结束标记了  也就是没了 继续读仍然是-1与ED  所以说这个数组它起到一个缓冲作用
        //我可让它一次读两个数据放到这个数组里面

        //数组的作用：缓冲作用，存储读取到的多个字节

        //那假如我创建了一个长度为5的byte[] 那一次读几个字节  一次读取5个字节就
        //那你里面放的是ABCDE 那我是不是一次性的就给你读出来 所以说提高了我读取的效率  所以说这就是它的一个原理

        /**
         * 发现以上读取时一个重复的过程，可以使用循环优化
         *  不知道文件中有多少字节 所以使用while循环
         *  while循环结束的条件  ，读取到-1结束
         *
         */
        byte[] bytes1 = new byte[1024];//存储读取到的多个字节
        int len3 = 0;
        while ((len=fis.read(bytes1))!=-1){
            System.out.println(new String(bytes1));//ABCDE                                                                              发现文件内容ABCDE后面有一堆的空格
                                                   //因为你的长度是不是1024而它就读了5个呀 后面是不是空着好多空间浪费了
                                                   //所以说转换的时候我们就不能这么转了 使用它的第二个构造方法来转

            //String(byte[] bytes,int offset,int length)把字节数组的一部分转换为字符串 offset数组的开始索引 length转换的字符个数
            System.out.println(new String(bytes1,0,len3));

        }

        //当使用字节流读取文本文件时，可能会有一个小问题，就是遇到中文字符时，可能不会显示完整的字符
        //因为  一个中文字符可能占用多个字节存储


        //所以java提供一些字符流类，以字符为单位读写数据，专门用于处理文本文件

        /**
         * 使用字节流读取中文文件
         * 1个中文
         *   GBK:占用两个字节
         *   UTF-8:占用3个字节
         *   而我这字节流一次是不是只能读取一个字节
         */
        FileInputStream fis3 = new FileInputStream("D:\\workspace\\Devlop\\c.txt");//假设内容是  你好 是一个中文
        //现在编码格式用的是UTF-8编码  所以说你占3个字节  好 占3个字节

        int len4 = 0;
        while ((len4=fis3.read())!=-1){
            System.out.println(len4);
            //228
            //189
            //160
                //这3个字节组成一个你
            //229
            //165
            //189
                //这3个字节组成一个好
            //所以说现在是UTF-8你好占用6个字节
            //那你看我现在就麻烦了  如果读一个字节我让它变成char类型  这是不是显然就不行了 是不是产生了一堆乱码
            // 因为我们每次它读取的是1/3个字节  读取这1/3个中文  那这后面你要写个abc这有问题吗  是不是没有问题  确实没有问题
            //这可变成字符  你好就挂了 因为你一次读取1/3个中文 它就转变不成字符  就会报这种错误 乱码的问题  这就是使用字节流
            //读取中文会产生乱码

        }




        //3.释放资源
        fis.close();


    }
}

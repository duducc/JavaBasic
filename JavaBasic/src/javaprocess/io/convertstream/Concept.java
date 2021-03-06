package javaprocess.io.convertstream;

/**
 * 转换流：
 *   1.inputStreamReader
 *   2.outputStreamWriter 一共有两个
 *
 *   前面介绍了一下使用FileReader读取GBK编码的文件出现了乱码问题
 *   怎么解决这个问题呢 就得需要使用今天要学习的转换流
 *   在看转换流之前 我们先看一下 这个FileReader
 *   jdk API文档中是这样描述的：
 *   用来读取字符文件的便捷类。
 *   此类的构造方法假定默认字符编码(所以说它可以使用默认的字符编码  也就是我们所说的IDE默认的UTF-8呀)和默认字节缓冲区大小都是适当的。
 *   要(我们自己指定这个编码)自己指定这些值，
 *   可以先在 FileInputStream 上构造一个 InputStreamReader。   FileReader 用于读取字符流。要读取原始字节流，请考虑使用 FileInputStream。
 *   (实际上我们这个FileReader它只干一件事 就是一件转换的事  它可以把这个字节查询UTF-8编码表转换为字符实际上我们硬盘存的文件，我们说过它是不是都是以字节的方式来存储的
 *     那怎么来读取字节  实际上是用的FileInputStream 来读的字节 所以说我们来看FileReader它的底层源码  发现它在构造方法中new了一个FileInputStream  ---> new FileInputStream(fileName)
 *     所以说它的底层实际上是用FileInputStream这个字节流来读取字节 然后呢 再通过FileReader把字节转换为我们能看懂的字符
 *   )
 *
 *   (
 *    我们再来看InputStreamReader  看这个流跟FileReader是什么关系  它是不是FileReader的一个父类啊
 *
 *    InputStreamReader 是字节通向字符的桥梁  所以它可以把字节转换为字符 它可以使用指定的 charset 读取字节并将其解码为字符  所以这个流它可以指定编码表
 *    不像刚才的FileReader它只能使用默认默认码表
 *    介绍 InputStreamReader它是怎么进行转换的
 *
 *    一个是GBK 中文码表 使用两个字节存储一个中文  就让他存储 你好-->-55-44(假设代表“你”),-33-34(假设代表“好”)   那它就会用两个字节来存储它
 *    除了GBK可以存储中文 我们说过还有一个编码表叫做UTF-8国际标准码表 它是不是也可以存储中文 但是它使用三个字节存储一个中文  你好-->-11-12-13(假设代表“你”),-19-56-78(假设代表“好”)
 *
 *    假设在电脑的硬盘上面有一个1.txt的文本文件  如果用GBK 实际上存储的是4个字节  如果用UTF-8的格式  实际上存储的是6个字节  所以编码不一样  占用的大小也不太一样
 *    那下面我要读取这个文件了 比如说用FileReader  那这个实际上底层也是用的FileInputStream字节流来读取的文件  所以说字节只能用字节流来读
 *    让FileInputStream字节输入流  来读取字节  它会把这个文件里面的字节给他读取出来  那现在比如我要读取这个UTF-8格式的
 *    那咱们用的这个流我是不是说过了用的是FileReader  用它来读  FileInputStream刚才读取出来字节  那这个FileReader它是不是只能查询系统默认码表  可以查询我们IDE的默认码表
 *    那IDE的默认码表是不是UTF-8  那所以它只能查询UTF-8这个编码表  查它有什么用  有什么目的  它可以把这个字节转换为字符  实际上这就叫做解码的过程  把看不懂的变成能看懂的
 *    那问题来了 如果我读取的是UTF-8文件的格式 那没问题啊  那我把这个字节在UTF-8一查 是不是前3个字节代表你  后3个字节代表好  就会把我们读到的这个字节转换为你好
 *    所以这就是正常读取出来的不会产生编码问题  就把这个你好读取出来在内存中了
 *    但是如果我让这个流读取GBK格式的你好 那就麻烦了  因为它只能查询默认码表UTF-8  而这个UTF-8它这个编码跟文件内从GBK编码对应不上的  如果把以GBK编码的字节用UTF-8转换为字符就
 *    出现了乱码（？？？） 所以我们这个FileReader它只能读取IDE默认编码文件 否则就会产生乱码
 *
 *    刚才我们又说了一个流InputStreamReader它实际上是一个转换流 那这个流有什么好处呢
 *
 *    下面我们使用它来读取文件 还是一样的读法  前面由字节输入流FileInputStream读取的过程不变  然后后面不用FileReader  而用这个叫做InputStreamReader它来读
 *     这个流只面有一句话  字节流通向字符流的桥梁  所以说它有什么好处  它强大在哪里了 它除了可以查询IDE默认码表   它还可以查询指定的码表（例GBK）
 *     那现在这个文件是GBK文件的  那我指定的是GBK 所以它一解码就会把这4个字节转换为你好  同样它也不会产生乱码  所以文件这两个你好读到内存中来了
 *     这就是转换流的强大之处 它可以指定编码表
 *
 *      那这里我们说了一个读的转换流那实际上除了读的 还有个写的
 *       比如我现在要把内存中的你好写入到文件中去  给它写入到一个记事本里面去 那我可以使用谁 写是不是可以使用FileWriter
 *       它也是一样的  它也是使用我们系统（也就是我们IDE）的默认码表  把这个你好给他转换为字节 把字符转换为字节（编码的过程）
 *       它会查询UTF-8把你好变成了几个字节  是不是6个字节  那我怎么给它写入到文件中 底层用的还是我们的字节流 （字节输出流 FileOutputStream）
 *       依次把这些字节写入到这个文件中去  那我写了几个字节  6个字节 那实际上这个文件是什么格式的文件？ UTF-8格式的文件
 *       那我要让他写GBK格式的文件 那这个流是写不了的 它只能写IDE默认编码  那我现在就想写一个GBK编码格式的文件 我怎么来写呢
 *       就可以找到咋们的转换流  叫做OutputStreamWriter  那咱们先找到FileWriter  它的父类叫做OutputStreamWriter
 *       它是字符流通向字节流的桥梁  也可以指定编码表把字符给它转换为字节 所以我们可以用OutputStreamWriter
 *       它也是一样除了可以查询系统（IDE）默认码表  还可以查询指定的码表   也是把你好字符给它转换为6个字节 然后用这个
 *       字节输出流（FileOutputStream）把它写入到我们文件中去 所以它的底层实际上用的也是字节输出流
 *       能不能写GBK码表格式的文件 当然可以 因为它可以指定码表  这样再写入到文件中去的时候 你好是4个字节 会以GBK形式存储在文件中
 *
 *       这就是转换流的作用：
 *          可以指定编码表  我可以读取任意编码格式的文件 我可以写入任意编码格式的文件
 *   )
 *
 *
 */
public class Concept {
}

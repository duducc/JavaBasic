package javaprocess.io.bufferStream;

/**
 *  缓冲流
 *      能够高效读写的缓冲流
 *      能够转换编码的转换流
 *      能够持久化存储对象的序列化流等
 *        这些功能更为强大的流，都是在基本的流对象基础之上创建而来的 相当于是对基本流对象的一种增强
 *        用来增强咋们那四种基本的流
 *
 *        若只是用基本的流，假如字节输入流   它去从硬盘的文件中读某个文件一个字节一个字节的读取
 *                                          这样就有一个效率问题 我在内存这里一层一层的调用
 *                                          读完再给我每个字节每个字节的一层一层返回  效率低下  这就是基本的流不管是字符流还是字节流都是一样的
 *
 *                                      例：字节缓冲输入流
 *                                           给基本的字节输入流增加一个缓冲区(数组) 提高基本的字节输入流的读取效率
 *                                           我们这里说的是读  其实写也是一样的
 *                                           所以这个缓冲流也叫做  bufferedInputStream(读的这个叫这个名字  字节缓冲输入流)
 *                                           BufferedInputStream(new  FileInputStream)//里面需要传递一个基本的字节输入流 母的呢就是给他增加一个
 *                                           缓冲区 给它增加一个数组
 *
 *
 *       若使用了缓冲流，假如字节缓冲输入流   再给基本的字节输入流增加了一个缓冲区之后 （数组）
 *                                          读文件的时候怎么读 我可以把这些所有的字节  都给它读到这个数组里面来
 *                                          把这个数组再给他整体给他返回  这样可以提高效率
 *                                          上面的是一次返回一个  这个时候是一次返回多个  可以放在一个数组里边
 *                                          其实它和我们再read()方法里面传递一个数组的含义是差不多的
 *
 *                       这就是缓冲流的一个原理  不管是字节的不管是输入的还是输出的  都是增加了这么一个数组
 *                                               为的就是提高我们读写的效率
 *
 *
 *                                     原理： 采用在创建流对象时，会创建一个内置的默认大小的缓冲区数组
 *                                             通过缓冲区读写，减少系统的IO次数，从而提高读写的效率
 */
public class BufferConcept {
}

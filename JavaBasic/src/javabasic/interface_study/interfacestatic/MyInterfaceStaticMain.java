package javabasic.interface_study.interfacestatic;

import javabasic.interface_study.interfaceabstract.MyInterfaceAbstractImpl;

/**
 * 注意事项：不能通过接口实现类的对象来调用接口当中的静态方法。
 *
 * 正确用法：通过接口名称，直接调用其中的静态方法。
 * 格式：
 * 接口名称.静态方法名(参数);
 *
 *
 */
public class MyInterfaceStaticMain {
    public static void main(String[] args) {
        MyInterfaceStaticImpl impl = new MyInterfaceStaticImpl();
        //错误写法！  这个接口  一个类可以实现多个接口 所以呢这么多 多个接口当中 静态方法有可能会产生冲突  所以呢这是一种错误写法
        //impl.methodStatic();//会发现点不出来这样一个方法 而且楞往上面写竟然会报错
                              //但是接口当中是有这个方法的  但它是静态类  那么实现类我也创建对象了，这个对象竟然不能调用

        //此前我们多次强调 静态跟对象有关系吗 没关系  静态跟谁有关系 跟类有关系
        //那我们象既然跟对象没关系  你干嘛还要new一个对象呢  所以上面的这种写法是错误的而且没有必要的


        ///直接通过接口名称调用静态方法
        MyInterfaceStatic.methodStatic();



    }
}

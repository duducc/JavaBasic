package javabasic.interface_study.interfaceformat;

import javabasic.interface_study.interfaceabstract.MyInterfaceAbstract;
import javabasic.interface_study.interfaceabstract.MyInterfaceAbstractImpl;

/**
 * 生活当中的接口就是一套公共的规则规范 那么在代码当中其实也是如此
 * 代码当中：
 *     接口就是多个类的公共规范  和生活当中差不多
 *     接口是一种引用数据类型，最重要的内容就是其中的：抽象方法。  也就是abstract这样的方法     （基本当中的四类八种当中有没有interface  没有   只要你不是基本类型 必然就是引用类型）
 *
 * 如何定义一个接口的格式：
 *    public interface  接口名称{   //当然接口名称它的规则也是每个单词首字母大写  大驼峰  和你的类名称是一样的只不过关键字我换了
 *          //接口内容
 *    }
 *
 *   备注： 换成了关键字interface之后，编译前的文件与编译生成的字节码文件仍然分别是  .java ---> .class
 *
 *   interface当中都可以包含什么内容
 *      如果是java7,那么接口中可以包含的内容有：
 *         1.常量(就是不能发生改变的量)
 *         2.抽象方法
 *      如果是java8，还可以额外包含有：
 *         3.默认方法  --java8 或者更新版本的jdk才可以做到的
 *         4.静态方法
 *      如果是java8，还可以额外包含有：
 *         5.私有方法
 *
 *    接口使用步骤：
 *       1.接口不能直接使用，必须有一个“实现”类来是“实现”该接口。  其实和继承差不多  称呼变一下
 *           格式：
 *             public  class  实现类名称 implements 接口名称{
 *                 //  。。。。
 *             }
 *       2.接口的实现类必须覆盖重写(实现)接口中所有的抽象方法。
 *           实现：去掉abstract关键字，加上方法体大括号。
 *       3.创建实现类的对象，进行使用。
 *    注意事项：
 *       如果实现类并没有覆盖重写接口中所有的抽象方法，那么这个实现类自己就必须是抽象类。
 *                  但凡有一个你自己就需要时抽象类，就好比把它拿下来 继承下来放在你肚子里
 *                             而具有抽象方法所在得类就必须得是抽象类
 */
public class InterfaceFormat {
    public static void main(String[] args) {
        //错误写法！ 不能直接new接口对象使用
        //MyInterfaceAbstract inter = new MyInterfaceAbstract();

        //创建实现类的对象使用
        MyInterfaceAbstract impl  = new MyInterfaceAbstractImpl();
        impl.methodAbs1();
        impl.methodAbs2();
    }

}

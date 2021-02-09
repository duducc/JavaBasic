package javabasic.interface_study.interfacedefault;


/**
 *
 * 1.接口的默认方法，可以通过接口实现类对象，直接调用
 *
 * 2.接口的默认方法，也可以被接口实现类进行覆盖重写。
 *
 * 备注： 接口的默认方法的使用非常的广泛 一个是用来解决接口升级的问题，再有一个是再lamda表达式和函数式编程的时候 接口的默认方法可以拼接函数模型
 *
 */
public class MyInterfaceDefaultMain {
    public static void main(String[] args) {
       MyInterfaceDefaultA a = new MyInterfaceDefaultA();
       a.methodAbs();//调用抽象方法，实际运行的是右侧实现类。

        //调用默认方法，如果实现类当中没有，会向上找接口的
       a.methodDefault();//这是新添加的默认方法

       MyInterfaceDefaultB b = new MyInterfaceDefaultB();
       b.methodAbs();
       b.methodDefault();//如果没有覆盖重写用默认的   如果你覆盖重写了那么你就改变了它默认的方法体你就写什么是什么了 ，那我就要听实现类的了  //实现类B覆盖重写了接口的默认方法

       //其实会发现 你MyInterfaceDefaultA与MyInterfaceDefaultB不用改 接口新添加的默认方法  不要求你去修改MyInterfaceDefaultA或者修改MyInterfaceDefaultB
    }
}

package javabasic.interface_study.interfaceprivate;

/**
 *
 */
public class InterfaceMain {

    public static void main(String[] args) {
        MyInterfacePrivateB.methodStatic1();
        MyInterfacePrivateB.methodStatic2();
        //错误写法
        //MyInterfacePrivateB.methodStaticCommon();//因为该方法时private的
    }
}

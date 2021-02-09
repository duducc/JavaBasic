package javabasic.interface_study.interfaceprivate;

/**
 *
 *
 *
 */
public interface MyInterfacePrivateB {


    //与前面的private是类似的 只不过不是default  而是static  那你在看 这也有问题
    //这种做法也不够恰当 因为你本来是两个静态方法 所有用到你的人要想点(.)  只能点出来两个方法 methodStatic1()和methodStatic2()
    //它不能点出来第三个
    // 结果你现在又给它加了一个methodStaticCommon()那这样的话所有用你的人都可能单独访问methodStaticCommon()方法
    //这么做不恰当  那怎么办
    //把methodStaticCommon()方法前的public换成private  这个是java9所添加的新的内容
    //这样一来private 只有本接口可以访问  在本接口中也就是只有methodStatic1()和methodStatic2()可以访问
    public static   void methodStatic1(){
        System.out.println("默认方法1");
        methodStaticCommon();
    }

    public static  void methodStatic2(){
        System.out.println("默认方法2");
        methodStaticCommon();
    }

    public static void methodStaticCommon(){
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }
}

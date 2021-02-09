package javabasic.interface_study.interfaceprivate;

/**
 *问题描述：
 *   我们需要抽取一个共有方法，用来解决两个默认方法之间重复代码的问题。
 *   但是这个共有方法不应该让实现类使用，应该是私有化的。
 *
 *
 *  解决方案：
 *     从java9开始，接口当中允许定义私有方法。
 *       1.普通私有方法   解决多个默认方法之间重复代码的问题
 *
 *          格式：
 *             private  返回值类型 方法名称(参数列表){
 *                 方法体
 *             }
 *
 *       2.静态私有方法   解决多个静态方法之间重复代码的问题
 *
 *             private  static  返回值类型 方法名称(参数列表){
 *                 方法体
 *             }
 */
public interface MyInterfacePrivateA {
    //如果是有方法体的两个方法之间它们重复的内容太多了
    //怎么办呢 我们就需要抽取一把
    //如下： 在下面两个方法中存在重复代码  那怎么办呢 我们给它抽取出来  就是重复的内容我只写一遍
    //当你们想用它的时候调用就行了  可以解决重复代码问题 对吗 对
    //但是 我现在的做法有所不妥  怎么不妥呢  你看本来说好是两个默认方法  但现在你把它变成了三个
    //我们说过默认方法一定是public的
    //那这就有一个问题 如果我们又增加了一个方法  那么子类 实现类也能访问出来你这个methodCommon()方法

    public default  void methodDefault1(){
        System.out.println("默认方法1");
        methodCommon();
    }

    public default  void methodDefault2(){
        System.out.println("默认方法2");
        methodCommon();
    }


    //虽然这种达到了重复代码使用的一个问题  但是是不恰当的
    //我抽取出了一个共有的内容 却成为了第三个新方法  第三个新方法如果默认 那它也是public
    //这就造成什么问题  为什么说它错误
    public default void methodCommon(){
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }
}

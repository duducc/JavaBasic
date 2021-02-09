package javabasic.interface_study.interfaceprivate;

public class MyInterfacePrivateAImpl implements  MyInterfacePrivateA {

    //定义一个你们都没有的  是我实现类专有的 跟你们谁都没关系
    public void  methodAnother(){

        //那我能不能写上一个super呢  不能
        //但是我能直接调用

        //直接访问了接口中的默认方法，这样是错误的！  为什么
        //因为这个methodCommon()是不能独立存在的 这个methodCommon()方法是专门为了methodDefault1和methodDefault2这两个方法   为了这两个方法而存在的
        //它只能被这两个人(方法)用
        //能不能被你实现类用呢  不应该这样  所以我们接下来就用私有方法进行改造
        //这个时候实现类就报错了  不能使用了


        methodCommon();

    }
}

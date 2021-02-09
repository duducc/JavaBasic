package javabasic.extend_study.superusing;

/**
 * super 关键字的用法有三种：  是用来访问父类内容的
 *   1.在子类的成员方法中，访问父类的成员变量。
 *   2.在子类的成员方法中，访问父类的成员方法。
 *   3.在子类的构造方法中，访问父类的构造方法。
 */
public class Zi  extends Fu {

    int num = 20;

    public Zi(){
        super();  //这就是子类的构造器正在访问父类的构造器 你不写 编译器也会默认赠送一个
    }

    public void methodZi(){
        System.out.println(super.num);//访问父类的成员变量
    }

    public void method(){

        //若就是想用父类当中的方法呢
        super.method();//访问父类当中的method()方法  但是这回事成员方法了


        System.out.println("子类方法");

    }
}



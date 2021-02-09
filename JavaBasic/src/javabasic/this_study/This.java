package javabasic.this_study;

/**
 * 当方法的局部变量和类的成员变量重名的时候 根据“就近原则“优先使用局部变量  参数 就是一个局部变量
 *
 * 但是有时候需要区分一下  我就是想要成员变量  怎么办
 * 如果需要访问本类当中的成员变量  需要使用格式：   就是一个关键字
 *
 * this.成员变量名（可以解决重名分不开的问题）
 *
 *
 * 重点  "通过谁调用的方法，谁就是this。"  this一定是写在一个方法里面的  不能说在类中方法之外写一个this  这是不行的
 *                                       那你方法肯定有人调用 你才会执行  谁调用的sayHello()    是This  t   调用的sayHello()  通过This(t)调用方法   那么This(t)就是this
 *                                       此时this.name  其实就是This.name  那This.name 就是对象名称.成员变量   访问的就是成员变量   就是  //我自己的名字了
 *                                       这就是this的原理所在
 *
 *                                       证明---    打印输出 this   发现地址值是一样的
 *
 *                                       //类型         @  地址值
 *                                       javabasic.this_study.This @ 1b6d3586
 *                                       javabasic.this_study.This @ 1b6d3586
 *
 *
 *                                       this主要用来的重名的情况下起到区分的效果
 *
 * 注意 - - - -    但是局部变量前面什么都不要写
 */
public class This {

    String name;//我自己的名字

    //参数name是对方的名字
    //成员变量name是自己的名字


    public void sayHello(String name) {//当参数名称不是name的时候 程序是没有问题的      但是当程序是name的时候  创建本来对象并为成员变量赋值的时候   会发现程序使用的是局部变量  程序输出的都是参数的名称
        //System.out.println(name + ",你好。 我是" + name);

        //添加this用来区分成员变量与局部变量
        System.out.println(name + ",你好。 我是" + this.name);

        //输出this  证明判断是谁
        System.out.println(this);

    }

    public static void main(String[] args) {
        This  t = new This();
        t.name="王健林";
        t.sayHello("王思聪");

        //输出对象 This   地址值  印证   被调用方法中的this  是否是调用方法的所属对象
        System.out.println(t);
    }
}

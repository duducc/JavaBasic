package javabasic.multi_study.multimethod;

/**
 * 在多态的代码当中，成员方法的访问规则是：
 *   看new的是谁，就优先用谁，没有则向上找。
 *
 *   口诀：
 *     编译看左边，运行看右边。  ---谨记   成员变量不在此口诀当中
 *
 * 对比一下：
 *    成员变量：编译看左边，运行还看左边。
 *    成员方法：编译看左边，运行看右边。
 *
 *
 */
public class MultiMain {
    public static void main(String[] args) {
        Fu obj = new Zi();

        obj.method();//父子都有，（你new的是子呀）优先用子

        obj.methodFu();//子类没有，父类有，向上找到父类


        //什么叫做编辑啊  你要编译通过了才能进行运行 编译时一个动作 能够把.java源代码翻译成.class字节码文件
        //那等于说红色出现了 编译没通过  为什么没通过
        //你看左边  左边是谁 左边是父啊，左边是Fu，Fu当中没有methodZi方法，所以编译报错。
        //什么叫做运行看右
        //比方说  我现在前两个是正确的
            //method()  首先看左  左边的Fu里面是不是有method  但真正运行的时候我要看右边  右边是Zi呀 那我当然就运行子类了
            //methodFu()  编译看左边 那左边Fu是不是有它呀  运行看右  右边的子类没有 我就向上找到父类
     // obj.methodZi();//错误写法！

    }
}

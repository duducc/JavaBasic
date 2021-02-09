package javabasic.extend_study.thisusing;

/**
 * super关键字用来访问父类内容， 而this关键字用来访问本类内容。 你不能说叫子类   因为父类不知道子类是谁  this 叫做本类的内容
 *
 * 1.在本类的成员方法中，访问本类的成员变量。  可以起到一个区分的作用
 * 2.在本类的成员方法中，访问本类的另一个成员方法。
 * 3.在本类的构造方法中，访问本类的另一个构造方法。
 *   在第三种用法当中要注意：
 *    A.  this(....)调用也必须是构造方法的第一个语句， 唯一一个。
 *    B.  super和this两种构造调用，不能同时使用。 因为它们各自都必须是唯一的
 *
 */
public class Zi extends Fu {

    int num = 20;


    //具体做什么事不重要  主要介绍什么叫做一个构造调用另外一个本类构造
    public Zi(){

        //super();  这一行不再赠送

        //this();  这样写不对  这不叫作另一个构造  这叫做自己调自己 是错误写法 你应该怎么办  在里面传上一个实参 例：
        this(123);//本类的无参构造，调用本类的有参构造 这叫做本类构造方法的重载调用

        //this(1,2); 错误写法    除了调用一个参数的还想再调用两个参数的  行不行？  不行  必须是第一个语句   也就是唯一一个


        //那这个时候若写了一个this()/this(...)语句 那你那super还赠送吗  super必须得是第一个  this也得是第一个
        //那你再赠送一个super()  那this() 就不是第一个了啊  你再把它们颠倒一下  不行啊  它们都必须是第一个啊

    }

    public Zi(int n){//可以调用两个参数的
        this(1,2);
    }

    public Zi(int n,int m){//两个参的再调会去无参的了  不行的   不要耍咋们的编译器   javac是很聪明的   这不就循环起来了吗  永远没有尽头  是错误的写法
        //this();
    }





    public void showNum(){
        int num = 10;
        System.out.println(num);//局部变量
        System.out.println(this.num);//本类中的成员变量
        System.out.println(super.num);//父类中的成员变量
    }


    public void  methodA(){
        System.out.println("AAA");
    }

    public void methodB(){
        //现在我想在调用B的时候也把A调用一下  那怎么办呢
        // 可以直接这么写
          methodA();
        //你还能怎么写呢
        this.methodA(); //还能用这种方式    那么这种方式我们就强调一下 这个methodA 可不是来源于父类的哟  是来源于本类当中的  起到一个强调的字面作用


        System.out.println("BBB");
    }
}

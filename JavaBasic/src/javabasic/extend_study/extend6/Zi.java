package javabasic.extend_study.extend6;

public class Zi extends  Fu{

    //若此时没有写构造方法  这里就有一个默认赠送的无参构造方法

    //
    public Zi(){

        //在调用父类无参构造方法    不写照样有  这是编译器给你赠送的  子类必须要调用父类的构造方法  所以你不写  隐含有这么个东西
        //super();

        super(20);//在调用父类的重载构造方法
        System.out.println("子类构造方法");
    }

    public void method(){
        //super();// 错误写法！ 只有子类构造方法，才能调用父类构造方法。
    }
}

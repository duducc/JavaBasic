package javabasic.extend_study.extend6;

public class Fu {

   /* public Fu(){
        System.out.println("父类无参构造方法");
    }*/
    public Fu(int num){// 写上这个就不会 默认赠送无参构造了
        System.out.println("父类有参构造方法");// 这个时候（Zi）子类构造方法就报错了  因为在子类中会赠送一个super()但是
                                           // 在父类当中由于已经存在了有参构造  因此就没有了赠送的无参构造方法  压根就没写
                                           //所以就会报错  这个时候怎么办  我们就可以 通过super关键字来调用父类重载的 有参构造
                                           //谁能对应 我就用哪一个
    }
}

package javabasic.extend_study.extend4;

public class Zi extends  Fu {

    //当正确覆盖重写了父类方法的时候 该注解不会提示错误
    // 当换了方法名称的时候  或者没有按照重写规则进行重写的时候
    // 注解就会提示错误
    //所以这个注解起到的是安全检测的作用

    /**
     * 注意: 这个注解就算不写，只要满足要求，也是正确的方法覆盖重写  是可选的
     */
    @Override
    public String method(){//返回值类型范围为String   此时这个返回值类型要小于等于 父类返回值类型  修饰符是public   子类的修饰符要大于等于父类的修饰符
      return null;//所有的引用类型   都可以用一个null来表示没东西
    }
}

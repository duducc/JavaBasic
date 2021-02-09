package javabasic.extend_study.extend2;

public class Zi extends  Fu{

    //此时子类当中除了我自己的 还有有继承下来的  有几个成员变量  两个  一个是numFu  一个是numZi
    int  numZi = 20;

    //与父类成员变量重名  开探索会有什么样的问题
    int num = 200;

    //
    public  void  methodZi(){
        //这个num用的是父类当中的呢还是子类当中的呢
        //因为本类当中有num所以这里用的是本类的num 你要是没有才往上找呢  你现在有的话优先用自己的了
        //那调用方法会是什么情况
        System.out.println(num);
    }
}

package javabasic.multi_study.multifiled;

public class Zi extends Fu {
    //如果不重名 那当然没问题了

    //只有你重名的时候咋们才需要了解一下规则
    //同时成员变量不能覆盖重写  只有方法才能覆盖重写
    int num = 20;

    int age = 16;

    @Override
    public void showNum() {
        System.out.println(num);
    }
}

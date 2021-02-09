package javabasic.extend_study.extend2;

public class Fu {

    int  numFu = 10;

    int  num = 100;

    public void methodFu(){
        //使用的本类当中的 不会向下找子类的
        System.out.println(num);//  这个methodFu()方法用的是本类当中的num还用的是我子类当中的num
    }
}

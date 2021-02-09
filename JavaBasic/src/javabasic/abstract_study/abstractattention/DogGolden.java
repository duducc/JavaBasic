package javabasic.abstract_study.abstractattention;

public class DogGolden extends  Dog {
    //你刚才父类Dog已经覆盖重写了抽象方法eat()方法  现在就只剩下一个sleep()了  那我们就来实现它一把
    @Override
    public void sleep() {
        System.out.println("呼呼呼。。。");
    }
}

package javabasic.abstract_study.abstractformat;

public class DemoMain {
    public static void main(String[] args) {
        //Animal animal = new Animal();//错误写法！ 不能直接创建抽象类对象

        Cat cat = new Cat();//创建的是子类对象当然运行的是子类方法  它父类是抽象类 里面根本就没方法体
        cat.eat();

    }
}

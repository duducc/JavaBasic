package javabasic.abstract_study.abstractattention;

public abstract class Dog extends  Animal {
    //那我们说了 子类一定要覆盖重写所有抽象方法  那如果我就不呢
    //现在抽象父类里面有两个抽象方法  但是我就只重写eat()方法  我不理那个sleep   那怎么办呢

    public  void eat(){
        System.out.println("狗吃骨头");
    }

    //但是当你只重写了一个抽象方法的时候会发现上面这个类还在报错  为什么 因为你落下了一个  还有一个sleep()方法你没管

    // public abstract void sleep();  你现在有一个抽象方法下来了   不是你写的  是你继承下来的  是不是有一个abstract  有 有的话 好比说是你这里有抽象方法
                                      //那它所在的类必须是抽象类  这样子类也是一个抽象类  在这种情况下我们如何来使用这样一个子类呢
                                      //它里面没说怎么睡觉啊  这个狗跟狗睡觉它还不一样
}

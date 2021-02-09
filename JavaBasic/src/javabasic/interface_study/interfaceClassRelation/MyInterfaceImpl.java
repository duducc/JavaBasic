package javabasic.interface_study.interfaceClassRelation;

public class MyInterfaceImpl implements  MyInterface {


    // 在这种情况下我只需要实现一个接口  它是一个子接口 它父接口的内容其实我这里也有  这就是我们所说的接口与接口之间的多继承
    //但是如果要是有冲突怎么办  我的MyInterfaceA和MyInterfaceB当中都有methodComm()  抽象方法你觉得你能抽象得了吗  不能 因为它没有方法体
    @Override
    public void method() {

    }
    
    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public void methodComm() {

    }


}

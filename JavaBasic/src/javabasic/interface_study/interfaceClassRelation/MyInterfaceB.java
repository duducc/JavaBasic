package javabasic.interface_study.interfaceClassRelation;

public interface MyInterfaceB {

    public abstract void methodB();

    public abstract void methodComm();

    public  default  void  methodDefault(){
        System.out.println("BBB");
    }
}

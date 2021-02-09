package javabasic.interface_study.interfaceClassRelation;

public interface MyInterfaceA {

    public abstract void methodA();

    public abstract void methodComm();

    public  default  void  methodDefault(){
        System.out.println("AAA");
    }

}

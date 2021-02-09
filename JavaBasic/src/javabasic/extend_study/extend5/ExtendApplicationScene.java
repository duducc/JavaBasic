package javabasic.extend_study.extend5;

/**
 * 继承的设计原则与方法覆盖重写的应用场景--
 *
 *  对于已经投入使用的类，尽量不要进行修改。
 *  推荐定义一个新的类，来重复利用其中共性内容，
 *  并且添加改动新内容
 *
 *
 * 尽量不要去修改那个老的类  想要新功能  你就继承它添加一点新东西
 * 对于已经有的功能  要想改的话  就用覆盖重写Override
 *
 *
 */
public class ExtendApplicationScene {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.call();
        phone.send();
        phone.show();

        System.out.println("============================");

        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }
}

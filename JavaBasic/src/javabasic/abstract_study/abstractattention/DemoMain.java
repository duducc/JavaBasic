package javabasic.abstract_study.abstractattention;

/**
 * 抽象类的注意事项：
 *    1.抽象类不能创建对象，如果创建，编译无法通过而报错。只能创建其非抽象子类的对象。
 *           理解：假设创建了抽象类的对象，调用抽象的方法，而抽象方法没有具体的方法体，没有意义。
 *    2. 抽象类中可以有构造方法，是供子类创建对象时，初始化父类成员使用的。
 *            理解： 子类的构造方法中，有默认的super(),需要访问父类构造方法。
 *    3. 抽象类，中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
 *            理解：未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设计
 *    4. 抽象类的子类，必须重写抽象父类中所有的抽象方法，否则，编译无法通过而报错，除非该子类也是抽象类。
 *            理解： 假设不重写所有抽象方法，则类中可能包含抽象方法，那么创建对象后，调用到了抽象的方法，没有意义
 */
public class DemoMain {
    public static void main(String[] args) {
        //创建一个子类对象 这回父类是不能直接new的对吗
        Zi zi = new Zi();
        zi.eat();
        //输出  抽象父类构造方法先执行！  然后是子类构造方法执行   那你说new不就是在调用它吗  但是你在Fu当中写上了abstract  不能直接new这个   public  Fu(){}
        //这个Fu要想运行，只能通过子类当中赠送的一个super();  只能通过这种方式去调用它  你直接new那是不允许的


        // Animal animal = new animal();//错误
        // Dog dog = new Dog();//错误 这也是抽象类   因为你但凡落下一个都不行
        Dog2Ha dog2Ha = new Dog2Ha(); //这是普通类 可以直接new对象
        dog2Ha.eat();//狗吃骨头
        dog2Ha.sleep();//嘿嘿嘿.....


        DogGolden dogGolden = new DogGolden();
        dogGolden.eat();//狗吃骨头
        dogGolden.sleep();//呼呼呼。。。


        //在这里一个爷爷  一个父亲  两个最底层的孙子

    }


}

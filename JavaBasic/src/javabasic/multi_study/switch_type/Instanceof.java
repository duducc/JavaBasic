package javabasic.multi_study.switch_type;

/**
 *
 * 如何才能知道一个父类引用的对象，本来是什么子类？
 *
 * 用什么办法  进行安全的向下转型呢  用instanceof关键字
 *
 * 格式：
 *
 * 对象  instanceof  类名称(类型)
 * 这将会得到一个Boolean值结果，也就是判断前面的对象能不能当做后面类型的实例
 *
 *
 */
public class Instanceof {
    //讨论一个问题 你怎么知道这个父类的引用，它所指向的对象本来是猫还是狗呢
    public static void main(String[] args) {
        Animal animal = new Cat();//本来是一只猫
        animal.eat();//猫吃鱼

        //如果希望调用子类特有方法，需要向下转型
        //那向下转型 你转成谁  你是转成猫呢 还是转成狗呢
        //万一要是写错了 根本来的不对应  就会报错吧



        //既然instanceo返回的是一个Boolean值  那我就可以想到if语句
        //先判断安全了 我才向下转型

        //  判断一下父类引用animal本来是不是Dog
        if(animal instanceof Dog){
            //如果是  那我就转Dog
            Dog dog = (Dog)animal;
            dog.watchHouse();
        }
        //判断一下这个animal本来是不是Cat  为了避免你给它转错了  我们需要先判断一下
        if (animal instanceof Cat){
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }



        giveMeAPet(new Dog());

        //有人会想  你这么写会不会有点多余  为什么 你既然想用这个狗的方法  你干嘛还向上转型呢
        //向上转  向下转  两种格式我确实都知道  但是你这个代码好像没有意义 只有演示的意义  确实如此
        //但是我们考虑另外一种情况  有的时候你这个animal可不是你自己new出来的
        //比方说 我现在有个main方法  这个main方法里面的代码  自己new了对象 自己去转
        //那如果我定义另外一个方法呢  方法接收一个参数 我叫Animal animal
    }

    public static void  giveMeAPet(Animal animal){
        //那现在你只要给我来一个动物就行  比方说 你给它给一个狗行不行 你给他传进去一个猫行不行

         //虽然要求是动物就行  但是我是不是要物尽其用啊     但是你给了我一个狗 既然是狗的话 你是不是看一下家
        //但是你这个方法参数是animal 你怎么知道是不是狗呢

        //  判断一下父类引用animal本来是不是Dog
        if(animal instanceof Dog){
            //如果是  那我就转Dog
            Dog dog = (Dog)animal;
            dog.watchHouse();
        }
        //判断一下这个animal本来是不是Cat  为了避免你给它转错了  我们需要先判断一下  这个时候就需要区分一下  这个时候不就有用了吗
        if (animal instanceof Cat){
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }
    }

}

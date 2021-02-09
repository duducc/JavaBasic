package javabasic.extend_study.extend5;


public class NewPhone extends Phone{
    @Override
    public void show() {
        //现在父类方法的  显示号码  功能 需要重用  如果要再写一次父类的相同代码  代码冗余
        //那怎么办呢 我是一个子类怎么样去访问父类的东西呢 有一个关键字 可以访问父类的内容 super
        super.show();//这就是把父类show()方法拿过来重复利用
                     //自己子类再来添加更多内容
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}

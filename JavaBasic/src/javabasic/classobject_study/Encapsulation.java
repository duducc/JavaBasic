package javabasic.classobject_study;

/**
 *
 * 面向对象三大特征：封装，继承，多态
 *
 *
 * 封装性在java当中的体现：
 * 1.方法就是一种封装
 * 2.关键字private也是一种封装   意思就是私有化  如何使用
 *
 * 封装就是将一些细节信息隐藏起来，对于外界不可见。
 */
public class Encapsulation {

    //例
    public static void main(String[] args) {
        int[] array = {5,15,25,20,100};
        int max = getMax(array);//该方法就是一个封装  有人替你干了
        System.out.println("最大值：" + max);

    }

    public static int getMax(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }


    //private封装的情况

    /**
     * public class Person{
     *     String name;
     *     int age;
     *     public void show(){
     *         System.out.println("姓名："+name+"   年龄："+age)
     *     }
     *
     *     当创建该类对象的时候
     *     如果调用show()方法  输出的是默认值
     *     当对该Person类的对象赋值时  可以随意赋值   不合理
     *
     *
     *     问题描述：定义Person的年龄时。无法阻止不合理的数值被设置进来。
     *     解决方案：用private关键字将需要保护的成员变量修饰。
     *     例   private  int  age
     *
     *     一旦使用了private进行修饰，那么本类当中仍然可以随意访问  但是！超出了本类范围之外就不能再直接访问了。
     *
     *     间接访问private成员变量，就是定义一对Getter/Settter方法   虽然这样也可以对成员变量赋值  但是至少可以再方法当中去判断处理是否合理
     *
     *
     *     必须叫setXxx或者是getXxx命名规则。
     *       对于Getter来说  不能有参数，返回值类型和成员变量对应
     *       对于Setter来说  不能有返回值 ，参数类型和成员变量对应
     *
     *     这就是关于private关键字的使用  有什么好处呢
     *       一旦写上private 外边无法直接访问  只能间接访问  这样间接的方式 我写点代码就能阻止那些不合理的数据被设置进来   提高代码的安全性
     *
     *
     * }
     */

    //练习使用private关键字

    /**
     * public  class Student{
     *     private String name;
     *     pirvate int age;
     *     pirvate boolean ismale;
     *
     *     (Getter/Settter)
     *     //....   但是对于boolean 类型的数据  获取的方法不是get  而是  isXxx()方法   set方法是不便的
     *
     *     也就是说  对于基本类型当中的Boolean值，Gettter方法一定要写成isXxx的形式，而setXxx规则不变
     *
     * }
     *
     */
}

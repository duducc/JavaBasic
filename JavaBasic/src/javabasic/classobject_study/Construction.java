package javabasic.classobject_study;

/**
 * 构造方法
 *     构造方法是专门用来创建对象的方法 当我们通过关键字new来创建对象时，其实就是在调用构造方法。
 *     new  后面的东西     其实就是构造方法
 *
 *     格式：
 *
 *     public   类名称  (参数类型  参数名称){
 *         方法体
 *     }
 *
 *     注意事项；
 *     1 构造方法的名称必须和所在类的名称完全一样，就连大小写也要一样    之前说过方法名第一个字母小写 而 构造方法时一个特例
 *     2 构造方法不要写返回值类型，连void都不写
 *     3.构造方法不能return一个具体的返回值  因为若方法的返回类型时void的 你只能写return;  不能return一个具体数值作为返回值的  但是return; 是可以使用的
 *     4.如果没有编写任何构造方法，那么编译器将会默认赠送一个构造方法，没有参数，方法体什么事情都不做  public Student(){}
 *     5.一旦编写了至少一个构造方法，那么编译器将不再赠送。  也就是说如果在类当中定义了一个有参构造方法那么若创建对象需要手动编写误餐构造
 *     6.构造方法也是可以重载的。  重载： 方法名称相同，参数列表不同
 *
 *
 *     目前  这个Student类  有四部分组成   private的成员变量    无参构造  全参构造   Getter Setter  其实它就是一个标准类  这样的类也叫做java Bean   bean是豆子的豆
 *                                        例如  憨豆先生  他叫做 Mr. Bean    Java  Bean  Java豆  其实就是一个标准的什么什么类
 *
 */
public class Construction {


    public static void main(String[] args) {
        Student stu1 = new Student();// new  构造方法()  new对象就是在调用构造方法  无参构造
        System.out.println("************");


        Student stu2 = new Student("赵丽颖",20);//全参构造

        //怎么使用   通过  student1  调用方法使用
        System.out.println("姓名：" + stu2.getName() + "年龄：" + stu2.getAge());

        //既然这样 那Getter Setter方法是不是就是多余了  其实不是
        //如果需要改变对象当中的成员变量数据内容，仍然还需要使用setXxx方法
        stu2.setAge(21);//改变年龄
        System.out.println("姓名：" + stu2.getName() + "年龄：" + stu2.getAge());
        //所以我们这些重载参数的构造方法只是方便我们在创建对象的时候把那些现成的参数设置进来  省去你多次调用setXxx()方法  这样的麻烦 但是当你去修改对象内容的时候  setXxx()方法还是有用的


    }

}


class Student{

    //成员变量
    private String name;
    private int age;

    //无参数的构造方法
    public Student(){
        System.out.println("构造方法执行了！");

        //return 100;  错误写法   不能产生返回值
        // return; //可以使用

    }
    public Student(String name,int age){
        System.out.println("全参构造方法执行了！");
        this.name= name;
        this.age = age;
    }


    //Getter Setter

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

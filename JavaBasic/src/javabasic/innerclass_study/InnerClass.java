package javabasic.innerclass_study;

/**
 * 内部类
 *   此前  介绍过 一个类就是描述一个事物的
 *         如果一个事物的内部包含另外一个事物，那么这就是一个类内部包含另一个类。
 *                   就是一个再里面  一个再外面 包起来的那个就叫做内部类
 *     例如：1.身体和心脏的关系  心脏脱离了人体还有没有用处呢  就算你是心脏移植  那也是把A移植到B的体内   也不是独立存活的  所以这都是外部包含内部
 *                              内部说的就是心脏 发动机  只有它在里面才可以正常进行工作   那既然类就是用来模拟事物的
 *                              你这个事物已经有了包含 我们的class类也可以产生包含关系  这就是内部类
 *
 *     又如：2.汽车和发动机的关系  这都是一个再里面 一个再外面  汽车是包含发动机的
 *             汽车的发动机你要是单独拿出来 它还就没法用    能不能给火车用呢？不能  你能独立存在的了妈？不能
 *             一定要在汽车的内部它才可以正常工作  掏出来就没有用了  这就是包含关系
 *
 *   内部类分类--
 *        1.成员内部类
 *        2.局部内部类（包含匿名内部类--是属于局部内部类当中的一种）
 *
 *
 *          成员内部类的定义格式：
 *            修饰符  class 外部类名称 {
 *                修饰符  class 内部类名称{
 *                    //。。。
 *                }
 *
 *                //。。。
 *            }
 *
 *          注意1： 内部类使用外部类我们叫做--内用外，随意访问  不管是什么修饰符 都可以随意访问权限不受影响  因为你是包含在里面的没有超过范围
 *                 外部类使用内部类我们叫做--外用内，一定需要借助内部类对象  一定要有内部的对象才能用
 *
 *          注意2： 若某一个类当中存在内部类  在生成.class的时候  会生成两个.class文件  一个是以外部类命名的.class文件
 *                                                                                   一个是以外部类$内部类的 .class文件
 *
 *                                                                                   因此在java命名规范里面是不建议使用$符号来给类命名的
 *                                                                                                     容易产生混淆  误认为是内部类
 *
 *   ==========================================================2===========================================================================
 *
 *   如何使用成员内部类？ 有两种方式：
 *   1.间接方式：在外部类的方法当中，使用内部类，然后main只是调用外部类的方法。
 *   2.直接方式： 公式：
 *                     类名称  对象名  = new  类名称();  一般的创建对象的方式
 *
 *                     但是现在有嵌套结构了  怎么写--
 *
 *                     【外部类名称.内部类名称  对象名  = new  外部类名称().new 内部类名称();】其实都是   外.内
 *
 *
 *
 *
 *  ==========================================================3===========================================================================
 *
 *  内部类的同名变量访问
 *
 *    如果出现了重名现象  那么格式是，外部类名称.this.外部类成员变量名
 *
 *
 *
 */
public class InnerClass {


}

class Demo01InnerClass{
    public static void main(String[] args) {
        Body body = new Body();

        //通过外部类的对象，调用外部类的方法，里面间接在使用内部类Heart    先找外部类的方法  外部类方法间接的去找的Heart
        body.methodBody();

        Body.Heart heart = new Body().new Heart();  //需要借助  外.内这样的格式来创建内部类对象
        heart.beat();
    }
}


class Body{ //外部类



    class Heart{//内部类  --而且是成员内部类  为什么说是成员内部类  因为你看我这个Heart是在方法外边  直接在类当中那就叫做成员

       //能不能也定义一些内部类的成员方法呢  可以

        //内部类方法
        public  void beat(){
            System.out.println("心脏跳动 ：蹦蹦蹦！");

            System.out.println("我叫 ：" + name);//正确写法！  因为你是在Body的里面  都可以访问private的内容
        }



    }


    //外部类的成员变量
    private String name;


    //当然也可以定义一些  构造方法  成员变量   getter  setter  都可以

    //外部类方法
    public  void  methodBody(){
        System.out.println("外部类的方法");
        new Heart().beat();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*****************************************************************内部类的同名变量访问**********************************************************************************/

class Outer{

    int num = 10;//外部类的成员变量

    class  Inner{

       int num = 20;//内部类的成员变量

       public  void  methodInner(){

           int num= 30;//内部类方法的局部变量

           System.out.println(num);//局部变量  就近原则

           System.out.println(this.num);//如果想要20  即访问内部类的成员变量

           //如果想要10怎么办    可不可以用super  不能 因为  内部类和外部类不是继承关系  此时内部类的父类是Object 并不是继承了你这个Outer
           //                                                                         你如果是继承关系 那么  可以说子类就是一个父类
           //                                                                          那我问你  心脏是不是一个身体  不是 所以这不是继承关系  用super是不行的

           //System.out.println(super.num);  //不正确

           System.out.println(Outer.this.num);//外部类的成员变量  加一个前缀

       }
    }
}

//测试  内部类的同名变量访问

class Demo02InnerClass{

    public static void main(String[] args) {
       Outer.Inner obj = new Outer().new Inner();
       obj.methodInner();
       //结果是   30   20   10
    }
}

/*****************************************************************局部内部类定义**********************************************************************************/


/**
 * 如果一个类是定义在方法的内部，那么这就是一个局部内部类。
 * "局部"  只有当前的方法才能使用它 出了这个方法外面就不能用了。
 *
 * 定义格式：
 *    修饰符  class  外部类名称{
 *         修饰符  返回值类型  外部类方法名称（参数列表）{
 *               class  局部内部类名称{ //  局部是在方法的内部  成员是在方法外面
 *                   //....
 *               }
 *         }
 *    }
 *
 *
 *    小结：
 *       类的权限修饰符：
 *          public  >  protected  > (default) > private
 *       定义一个类的时候  权限修饰符（可以使用）规则：
 *       1.外部类 public/  (default)  只有这两种 剩下都不行   能不能是private  不行 private 是本类当中 （ 再单独新建的类的时候 这里只是暂时写再一个。java当中了） 你外部
 *                                    还有没有类呢 没了 你就是最外边的了  你再往外边 就没有了所以不能用private
 *                                    protected  你最外边都没有类  没有最外边了  所以说没有外边的子类  所以protected也是不行的
 *       2.成员内部类  public  protected  （default）  private  都可以 都能使用
 *
 *       3.局部内部类   什么都不能写
 *
 *                         //刚才在定义Inner的时候 发现前面什么修饰符都没有写  为什么呢  它不是成员  只有你当前方法自个儿可以用 所以什么都不能写
 *                         //可以认为它是一个（default--不是default关键字代表的是什么都不写） 但其实它并不是这个含义  这个玩意什么都不写
 *                         //那就是本包当中是可以访问的  那这个局部内部类本包当中是不能访问的   你是局部的  只有当前方法自个儿才能用  所以你什么都不能写
 *                         //而且效果跟（default）是不一样的
 */
 /*public*/ class PartOuter{

    public void  methodOuter(){
        class Inner{//局部内部类    如何对他进行使用呢  想法设法能够调用到methdoOuter()就可以了  那怎么调用  创建对象呗
            int num =10;
            public void methodInner(){
                System.out.println(num);
            }
        }
        //  5
        Inner inner = new Inner();
        inner.methodInner();
    }

}

class DemoMain{
    public static void main(String[] args) {
        //先把对象创建出来
        PartOuter obj = new PartOuter();
        //那里面的这个怎么使用呢
        //需要注意的是  我这个是局部的  我能不能超出方法之外   在方法外边  例 我从这里的main方法这里从外界   想访问你这个Inner(局部内部类)能不能做到  做不到
        //因为只有当前所属的方法才能使用它 出了这个方法就不能用了 等于说Inner只有你自己  上面的methodOuter（）方法才可以用它
        //怎么使用  你只能在   5的位置创建使用 也就是 方法内部使用
        //然后想法设法调用这个上面的methodOuter（）方法  这里在main（）方法调用的时候就不要用那个公式了  因为它是局部的

        //开始调用
        obj.methodOuter(); //结果输出10   这样其实就是在调用一个普通外部类对象的成员方法  里边呢   在方法内部定义了一个类 然后呢根据这个类 我自个儿当前这个方法
                           //  用这个局部的内部类 创建了一个对象然后再来调用它  除了我  别人谁用都不行

    }
}
/*****************************************************************局部内部类final问题****************************************************************************
 *
 * 局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final的】？
 *             就是说在该例当中 你这个num不能变
 *
 *   备注：
 *      从java8+ 开始，只要局部变量事实不变，那么final关键字可以省略。
 *
 *     1. new 出来的的对象在堆内存当中，
 *     2. 但是局部变量是跟着方法走的在栈内存当中。  这两个内存位置不一样吧
 *     3.方法运行结束之后，立刻出栈，局部变量就会立刻消失。
 *     4. 但是我new出来的对象会在对当中持续存在，直到垃圾回收为止  你要是不回收 比如说别的地方还有用 那在堆当中 你new出来的这个对象会持续存在的等于说这两个谁活的久呢
 *        是MyInner它的对象活的久  那这就有一个问题  有可能你这个局部变量已经消失了 但是我这个对象仍然还活着
 *        偏偏呢 我活着的对象还想用你这个局部变量  但你已经没了呀 你已经死了呀 那我怎么来用你呢   这个时候就需要copy一下
 *        只要你保证你一直都是10（假设本例的局部变量num值） 不能变  我就能把这个10给你复制进来 那我想用我就用常量池   常量的话肯定不会变吧
 *        那我什么时候用  复制过来 你走吧 反正你那个10我已经拿到了 你死去吧 不用你了 可以吧  这就解决了生命周期的问题
 *
 *        因为  如果你是可变的   你变来变去的   当我局部内部类在想用你的时候  你变到哪了  就没法说了
 *
 *        所以这里面生命周期不一样     你想要死  你给别人留下的这个数据得是唯一不变的
 *
 *
 *
 *    分析与原因--
 *
 *        关键就在于它为什么不能变  不能变就是常量么   要么你别用 要用就得是常量
 *        请注意 跟生命周期有关系  什么叫生命周期的 --在内存当中 活的早晚 活的长短就叫做生命周期
 *        那你现在看
 *          局部变量是跟着方法走的吧    那你现在有一个MyInner  MyInner是一个类吧
 *          一个类我就能new它 对吗  创建一个对象 请问new出来的对象 在什么内存里面
 *          在堆内存里面  这两个内存位置不一样  那你想methodOuter()这是一个方法
 *          它如果要运行完毕以后 你这个num还有吗  就没有了
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

class  MyOuter{
    public void methodOuter(){
        int  num =10;//所在方法的局部变量   那现在很明显你没写final啊  没写final也叫有效final  我问你 它变了吗 没变啊
                     // 你只赋值了一次  但如果你愿意在那里写上final就更保险了
                     //倘若你没有写final 接着又对它进行赋值了  那么它就不是有效final的了   在局部内部类当中
                     //就不能使用  这是怎么回事呢
                     //其实在jdk的早期版本   java7以及更早的版本当中  内部类  局部的这种  去访问所在方法的局部变量  必须手动写上final 就不能让你变
                     //但是为什么现在我不写它也行  只要你保证它事实（真正的）不变  它确实不变 那么final关键字是可以省略的  是java8或更新版本的特性
                     //

        class MyInner{
            public void methodInner(){
                System.out.println(num);
            }

        }
    }
}

/*****************************************************************匿名(没有名字)内部类【重点】***************************************************************************
 *
 *
 *
 *   如果接口的实现类（或者父类的子类）只需要使用唯一的一次  就这种类它是实现一个接口 或者是有一个父类 而这样的类只需要使用唯一的一次
 *    那么这种情况下就可以省略掉该类的定义  而改为使用【匿名内部类】。
 *
 *    匿名内部的定义格式：
 *
 *         其实也简单  此前我们说过接口不能直接new   那现在呢   你就直接new接口 然后再后面再多点东西
 *
 *         //之前方式
 *         接口名称  对象名 = new  实现类名称();
 *
 *         //现在情况  你这个实现类只想用唯一的一次  那怎么办  就不要单独定义它  我们右边new   就写接口名称(){};
 *
 *          接口名称  对象名 = new  接口名称();    -------直接写  接口名称(); 这样算错
 *
 *
 *
 *          接口名称  对象名 = new  接口名称(){    ------- 正确写法   {}末尾分号不要丢
 *
 *              //覆盖重写所有抽象方法
 *
 *          };
 *
 *          这样看上去有点诡异  怎么就匿名了呢  怎么就内部类了呢
 *
 *
 *          在  new MyInterfaceImpl  的时候 它是单独定义的  是一个文件   那这个单独的文件我只是new的时候用了唯一的一次  后面就在没用了
 *          那你是不是  要右键   点开发工具里面的new去创建 还要起上一个名字啊   还需要写  implements  还需要些 override   然后再写方法
 *          稍微错一点都不行  有没有简便方法  我们来使用匿名内部类    见-------  MainDemo类中main方法中的  //使用匿名内部类
 *
 *   匿名内部类的注意事项：
 *
 *         对格式  new  接口名称(){....}  进行解析：
 *
 *         1.new代表创建对象的动作
 *
 *         2.接口名称就是匿名内部类需要实现哪个接口
 *
 *         3.{. . .} 这才是匿名内部类的内容
 *
 *    另外还需要注意几点问题
 *         1. 匿名内部类,在【创建对象】的时候,只能使用唯一一次。
 *             如果希望多次创建对象,而且类的内容一样的话,那么就必须使用单独定义的实现类了.   --也就是说你要么重复写2便  要么你定义一个impl是实现类  impl你就可以多次使用了
 *                                                                                       --所以这个大括号 只能在你new对象的时候使用唯一的一次  你想在new就得再来一个大括号
 *         2.   匿名对象，在【调用方法】的时候，只能调用唯一一次。
 *                  如果希望同一个对象，调用多次方法，那么必须给对象起个名字
 *                  （你现在这个05现在没有名称了） 那你现在调用的是method1()  还能不能接着  " . " method2()  这样写  是不行的  如果要这么写  那叫做把 调用method1()方法的返回值
 *                    作为对象来调用method2()  但是我没有返回值啊  方法是void类型的 所以这样写是错误的  那怎么写
 *                    你没有办法让一个匿名对象使用第二次   调用方法的时候 你只能在来一个
 *
 *
 *                    //因为匿名对象无法调用第二次方法，所以需要再创建一个匿名内部类（前者）的匿名对象（后者）    注意：前者是省略的是类名称   后者省略的是对象名称  这两个可不是一回事
 *                    // 复制一份05  再去调用method2()方法  但是匿名内部类的这些内容  你都得重复再来一遍
 *                    //虽然  匿名可以给我们带来一些便利 省去一些东西 但它不是瞎用得  如果你想要重复使用  就不要使用任何匿名的东西
 *       3.匿名内部类是省略了 【实现类/子类名称】，但是匿名对象是省略了【对象名称】  一个是省略了类  一个是省略了对象名称  这两不是一回事
 *          强调： 匿名内部类和匿名对象不是一回事！！！
 *
 *              --如果我的接口当中有两个方法怎么办
 *
 *
 *
 *
 *
 */

//接口
interface  MyInterface{//方法能不能直接运行   接口能不能直接new  需要一个实现类 如下MyInterfaceImpl
    public abstract void  method1();
    public abstract void  method2();
}

//接口实现类
class MyInterfaceImpl implements MyInterface{

    @Override
    public void method1() {
        System.out.println("实现类覆盖重写了方法  111");
    }

    @Override
    public void method2() {
        System.out.println("实现类覆盖重写了方法  222");
    }
}

//如何使用
class MainDemo{

    /**
     * 目前我们看到在本例当中  你这个  MyInterfaceImpl  是实现类 你这个是实现类 用了几次啊  在main方法当中找找  你这个MyInterfaceImpl就用了一次
     * 就是在你new它的时候    你才用了这个实现了 那后面呢  后面就没有这个实现类什么事了
     * @param args
     */
    public static void main(String[] args) {
        //1.直接创建实现类使用
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.method1();
        //2.接口指向实现类  多态使用
        MyInterface obj1 = new MyInterfaceImpl();
        obj1.method1();

/*************************************************************************************************************************/
        //使用匿名内部类
        MyInterface obj2 = new MyInterface() {// 01  是匿名内部类 但不是匿名对象  对象名称是obj2
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法 111-A");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法 222-A");
            }

        };//02

        obj2.method1();
        obj2.method2();

        //使用匿名内部类
        MyInterface obj3 = new MyInterface() {//03
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法 111-B");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法 222-B");
            }

        };//04

        obj3.method1();
        obj3.method2();



        new MyInterface() {//05    是匿名内部类 也是是匿名对象
            @Override
            public void method1() {
                 System.out.println("匿名内部类实现了方法 111-B");
            }

                    @Override
            public void method2() {
               System.out.println("匿名内部类实现了方法 222-B");
            }

        }/*06*/;

        //如果现在说我想用一下匿名对象  什么叫匿名对象  就是没有对象名称  现在从01-02 是匿名内部类 对象名叫什么  对象名就叫做obj2
        //                                                                从03-04  对象名叫什么  对象名就叫做obj3
        //                                                                       它省略的是类名称不是对象名称  你现在01-02   03-04  是匿名内部类
        //                                                                        但不是匿名对象 对象名称就叫做obj2
        //                                                          那对于obj3而言我不想要这个对象  那么办  我把左边的包括=的删掉  如  05

        //                                   那这是什么  使用了匿名内部类，而且省略了对象名称，那这也是匿名对象
        //                                   你是不是直接new了  new了左边你有名字吗  没名字  那咋们就写 在06位置写上 " . "  直接大括号后面 " . " 上 method1()   去掉后面的
        //                                         obj3.method1();
        //                                         obj3.method2();
        //

/*************************************************************************************************************************/

        //仔细观察   在  这个匿名内部类创建中从大括号{}开始到结束当中 里面的格式和你单独定义去实现接口时没有区别的，完全一样
        //现在你是单独创建.java文件 定义了一个类 大括号 写了这些    但是匿名内部类我直接写上一个接口名称  后面直接来上一个大括号
        //注意  注意  从大括号 " { " 开始 到   " } "  结束  这就是一个局部内部类     " ; "  只是一个结束符号
        //它就是一个类 类其中可以覆盖重写吧  但是我这个类叫什么名字  你以为这个 MyInterface就是名称吗  不对呀  MyInterface说的是接口名称  不是类名称
        //明摆着  是单独定义的接口  名称在上面写着呢  这是接口名称
        //那从  从大括号 " { " 开始 到   " } "  结束     你说是一个类  那这个类有名字吗  没名字  那你又是局部内部类
        //所以  从大括号 " { " 开始 到   " } "  结束      就是匿名内部类  它没名字
        //那你说为什么在  {}前面写上 一个接口 MyInterface呢  这是干什么用的   就是因为你new了这个 MyInterface()接口  这个接口它的名字是作为你覆盖重写时候使用的
        //你说你这个类 你new上一个接口以后 这个大括号是不是得覆盖重写呀       接口里面方法肯定要覆盖重写  对吧  所以呢  覆盖重写 抽象方法在哪定义的
        //就在你 new MyInterface(接口名称) 接口中定义的  所以我们在new后面写上了接口名称  那后边 谁算类   MyInterface obj2 = new MyInterface()  这都不算类
        //谁算类 大括号   " { " 开始 到   " } "  结束  这算是一个没有名字的类 这叫匿名内部类  同时它实现的这个接口用的不是implements关键字
        //而是直接往前写来上一个()  前边写的接口名称是谁 那我就要覆盖重写谁的抽象方法  这就是匿名内部类
        //那 我现在已经用了它吧  那我们现在就来 " . "
        obj2.method1();//直接运行  输出   --匿名内部类实现了方法--  也就是说根本就没用单独定义的是实现类


        //也就是说 这样 我们就省掉了一个类的单独定义  随着用 随着就把它定义出来了
    }
}

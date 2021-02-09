package javabasic.extend_study.superthisram;

public class Demo {
    public static void main(String[] args) {
        Zi zi = new Zi();

        //首先看一下show()方法
        zi.show();// 30  20  10  可以正确区分

        //那我再访问method();
        zi.method();//这就是    子类方法   如果在method()方法中加上super.method() 输出的是  父类方法  子类方法


        /**
         *
         * 在上面的案例当中   有super关键字  也有this关键字
         *
         *    结合一起分析一下  内存关系图
         *
         *    简略版代码如下：
         *        Fu{
         *          int num=10;
         *          method(){}//父
         *        }
         *
         *        Zi extends Fu{
         *            int num = 20;
         *            method(){}//子
         *            show(){
         *                int num = 30;
         *                sout(num);//30
         *                sout(this.num);//20
         *                sout(super.num);//10
         *
         *            }
         *        }
         *
         *        Demo{
         *            main(String[] args){
         *                Zi zi = new Zi();
         *                zi.show();
         *                zi.method();
         *            }
         *        }
         *
         *    内存结构：
         *
         *      栈：
         *
         *         Zi  zi     //保存的事一个地址值
         *
         *
         *      堆：
         *
         *
         *
         *      方法区：
         *         程序要想运行  谁最先有东西呢  肯定是方法区
         *
         *         它里面就给你写上了
         *
         *           Fu.class{ //这就是Fu类.class当中的内容
         *               int num
         *               method()//父
         *           }
         *
         *           Zi.class{//因为有了继承 所以Zi.class有一点不同
         *               //但是今天有了继承关系  要让你了解一下 它其中有一个
         *               [[super_class]]  //这东西不是你写的 也不是我写的 是你编译完了之后.class文件当中所拥有的一个特殊标记
         *                                //这玩意它其实是一个指向 它指向了谁呢  它指向了父亲（父类）
         *                                //super_class 就是从Zi.class里做一个标记 告诉它父亲（父类）是谁  这就是好比 你写的extends 关键字
         *
         *                  int num
         *                  method()//子
         *                  show()
         *           }
         *
         *           Demo.class{
         *               main(String[] args)
         *           }
         *
         *           //这就是方法区当中的所有内容  那谁最先运行呢  肯定是main方法先进栈
         *
         *           main方法进栈之后我就要看它做了什么事
         *             首先创建了一个子类对象
         *              Zi zi = new Zi();   在堆里面new Zi()对象
         *              那就再堆里面有一块大的空间  因为今天的Zi对象 还具有继承关系
         *
         *              这块空间当中 是子类内容    然后还会在该空间 在创建一个空间叫父类内容（嵌套在子类内容当中） 注意： 子类对象当中包含一个完整的父类结构
         *              所以说呢 你一定是先把父类构造执行完了 父类都已经有了 我呢再在这个内容的外围写上子类内容 是这么回事 里面的是父  外面的是子
         *              那咱就来说里边这个父都有什么东西
         *
         *                 父（子类内维空间）：
         *                    int num = 10  //你呢往里面赋值了吧  赋上了一个10
         *
         *                    //后面还有一个method()
         *
         *                    0x method() //父   什么叫0x --地址值    这个堆当中的方法保存的是一个地址值 哪个地址值 父亲（父类）的地址值
         *
         *                    01----super   代表里面这些东西
         *
         *      子（父类外维空间）：
         *        int num = 20;
         *        0x method //子
         *        0x show
         *
         *        02----this  代表外面这块东西
         *
         *
         *        现在父类也好  子类也好 都已经在堆当中创建好了
         *          那么就有两个关键字   一个是this   一个在super
         *
         *          //此时该Zi()对象 有一个地址  如  0x666   这个地址就被保存在栈中Zi  zi 当中
         *          //那这个对象和以往有什么不同 不在是一层了    两层嵌套结构
         *          //那后面 你对象已经创建好了  zi当中呢 你又调用了一个show()  这是一个方法调用啊  既然方法调用
         *          // zi->0x666  你直接调用了一个show  你看  直接找到的不就是子类内容当中的show()方法吗  那只有子类才有show方法啊
         *          //我就让你进栈  在栈当中开辟一块空间    它里面要做的事情还是挺多的
         *          //里面定义了一个局部变量
         *            int  num = 30；
         *            sout(num)//30  --02位置
         *            sout(this.num)//20  --03位置
         *            sout(super.num)//10  --04位置
         *
         *            // 但关键是这俩怎么来的  你看02位置的num没有任何前缀  它肯定会用这个局部变量
         *                                    你看03位置  那this呢  谁是this 子类呀 （说白了就是子类内容）   03位置的this 和  子类内容的位置的this是一个指向的动作
         *                                                一旦你写上了this  那我就用this所代表的外围空间  所以20就能出来
         *                                    你看04位置 super  那super在哪呢 super在内维空间(父类内容)里边  所以04位置的super 指向的是内维空间(父类内容)里面的(super)
         *                                                那这回super.num当然是里边(父类内容)的num了 所以呢这个10 就能给你显示出来了
         *                           这就是当你去通过zi.show()调用的时候我让它的方法进栈(此时mian方法中的zi.show()指向的是进栈的show()方法)
         *                           那这一个语句就已经结束了
         *
         *
         *                           接下来 我们又调用了 zi.method();  method()可跟之前不一样   zi.method()也得进栈吧  那我就看zi.method()  Zi当中有没有method()
         *                                  有啊   有的话我就让你进栈  但是我选哪个  优先用Zi对吗   好  zi.method()进栈来上一个小方格(开辟的一块空间)
         *                                        但是在这个方法里面你有一个很特殊的写法  有一个super.method()  就这一行  你就要看super在哪呢
         *                                        super应该是父类的内容(内维空间)对吗 那父类当中是不是有一个method() //父  啊？  对吗  好  所以说
         *                                        我们就还要再进栈  这回进栈 我们就让method() //父  进栈了  这个时候Zi中method()中super.method() 就根据这一行
         *                                        让method() //父进栈 即super.method指向刚才进栈的method() //父   这是子类的method()方法调用了父类的method()方法
         *                                        那父类要是完了 就出栈  然后子类方法也完了 也就出栈了  后面main()方法也完了 就出栈了所以所有的内存就都已经消失不见了
         *
         *              最后：  在这里我们分别演示了三种不同类型变量 应该说有本方法的局部变量  还有本类的成员变量 还有父类的成员变量  然后是子类方法 还有父类方法整体的内存演化过程
         *
         *
         *
         *
         */
    }
}

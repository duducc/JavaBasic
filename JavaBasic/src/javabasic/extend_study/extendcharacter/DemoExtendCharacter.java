package javabasic.extend_study.extendcharacter;

/**
 * java继承的三个特点：
 *
 *  1.java语言是单继承的。
 *   一个类的直接父类只能有唯一一个。也就是说父亲是唯一的 直接父亲    爷爷的不算
 *
 *    class  A {}
 *    class  B extends A{}//正确
 *
 *    class C {}
 *    class D extends A,C {} //错误
 *
 *    //下面解释一下为什么不行
 *
 *       //现在我们假设可以多继承  也就是让D同时继承A和C  为什么这种情况不行呢 你假设你的父类A   C也是父类   D是一个子类 那父类东西子类会继承的吧
 *
 *       //在A(父类)里面要是有一个method(){A}的呢  在C(父类)的里面写了一个method(){C}  那现在这两个要是都能往下继承的话
 *       //那再D(子类)里面是不是就有东西method()的了   但是一个说让你打印 A  一个说让你打印 C
 *       //那如果我要是写上一个代码
 *       // D d = new  D();
 *       // 我就只管调用
 *       //  d.method() // 你觉得这里是 A or(还是)  C 呢  这就有矛盾 它就容易蒙圈  它就分不清楚了 因为它的亲生父亲尽然有两个人  你觉是A 还是 C 呢   哪个都不是
 *       //  哪个都不是  这是一种矛盾的现象  你说父亲 A  让你打印A  是不是得听它得    父亲 C  让你打印C  是不是也得听它的 两个父亲呀 那不像话呀
 *       //  我只听亲生父亲的 所以父亲只能有一个  这就是解释我们java为什么是单继承的
 *  2.java语言可以多级继承
 *
 *          我有一个父亲，我父亲还有一个父亲，也就是爷爷。
 *
 *           class A{}
 *           class B extends A{}//正确
 *           class C extends B{}//正确
 *
 *           //那在这里假如每个类用一个小方格表示的话 它们就是一溜子顺着下来的
 *           //那在这里 A是B的父类  B是C的父类   那A是C的父类  也这么说 我们就把这个父亲  爷爷模糊一下 因为这里的层次可能摞的很高啊
 *           //所以A是不是C的父类呢  也算  但它是不是C的直接父类？ 不是
 *           //哎 这里面就要注意了  A-->B--->C  虽然摞的很高  但是父亲唯一  直接父亲唯一 这个原则是不能打破的
 *           //java当中的Object类是最顶端的 再往上就没有父类了  是整个继承体系当中的祖宗类
 *
 *  3. 一个子类的直接父类是唯一的，但是一个父类可以拥有很多个子类。
 *              可以有很多个兄弟姐妹，生二胎。
 *           class A{}
 *           class B extends A{}//正确
 *           class C extends A{}//正确
 *
 *           //同样每个类用一个小方格表示
 *           //那组成的形状是一个品字形的   即 两个B与C子类指向上面的 A 父类
 *           //这个品字形是正确的  因为这一个父类它可以拥有好多个子类  兄弟姐妹呗   你是老大 它是老二 对吗  当然了在这里并没有排名  它们俩就称之为兄弟类 当然这只是一个比喻
 *
 *
 *
 */
public class DemoExtendCharacter {
}

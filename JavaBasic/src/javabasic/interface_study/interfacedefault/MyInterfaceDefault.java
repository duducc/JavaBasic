package javabasic.interface_study.interfacedefault;

/**
 * java8开始，接口里允许定义默认方法 （是可以有方法体的）
 *  格式：
 *    public default 返回值类型 方法名称(参数列表){
 *        方法体
 *    }
 *   默认方法会被你的实现类继承下去的
 *
 *    那你说这样的默认方法为什么要叫默认呢   ---它其实是为了解决接口升级的问题
 *
 *    备注：接口当中的默认方法，可以解决接口升级的问题。
 *
 *       什么叫做接口升级呢
 *          解释：
 *             当前的接口有两个实现类分别是MyInterfaceDefaultA与MyInterfaceDefaultB  它们两个都实现了MyInterfaceDefault该接口
 *             并且覆盖重写了该接口所有的抽象方法， 倘若现在由于业务的变化 需要在接口中添加新方法 那么这两个实现类都必须要再次
 *             去添加重写该接口的抽象方法，但是两个实现类已经投入使用了  那如何保证这两个实现类是固定不动的 我就只管这一个方法  我不想再去添加与实现这个方法的代码了
 *             但是我接口当中还想再加一个方法，而且这个添加动作还让它的实现类不需要重写（即不想让它不报错）方法
 *             那怎么解决这种矛盾呢 ，我们就需要你添加的这个新的方法拥有默认的方法体 而这个带有方法体的 就是默认  default方法
 *             这个时候就需要将该接口当中的方法定义为默认的方法
 *
 *
 *
 */
public interface MyInterfaceDefault {

    //抽象方法
    public abstract   void  methodAbs();

    //新添加的方法，改成默认方法   会发现该接口的实现类并没有提示错误让我们强制去重写该方法
    public default  void  methodDefault(){ //此时public发现是一个灰色的  它是可以省略的  但是你不能换成其他的  如protected    所以这个public省略不写它也是public  但是default你可不能省略
        System.out.println("这是新添加的默认方法");
    }
}

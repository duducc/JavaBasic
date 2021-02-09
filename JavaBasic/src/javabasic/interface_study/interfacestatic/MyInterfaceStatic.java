package javabasic.interface_study.interfacestatic;

/**
 * 如果是一些内容跟对象没关系 是同类对象所共享的内容 那这样就与类相关  static的  这种方法 跟什么什么对象没关系
 *    例  有一个学生叫小明 它运行这个方法  还有一个学生叫小红 它也运行这个方法  这两方法丁点区别没有  这就叫跟小红小明没关系  跟学生有关系
 *
 *
 *从java8开始，接口当中允许定义静态方法。
 *  格式：
 *    public static 返回值类型 方法名称(参数列表){//也是带有方法体的
 *        方法体
 *    }
 *
 *    提示：就是将abstract或者default换成static即可，带上方法体。
 *
 *    用法: 我们静态方法是通过类名称直接.(点) 那我现在是在一个接口里面，接口当中怎么用这个静态方法呢 一样 也是通过接口名称直接.(点)
 *
 */
public interface MyInterfaceStatic {

    public  static void  methodStatic(){//public 是可以省略的
        System.out.println("这是接口的静态方法！");
    }
}

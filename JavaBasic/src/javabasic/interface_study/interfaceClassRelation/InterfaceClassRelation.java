package javabasic.interface_study.interfaceClassRelation;

/**
 * 1.类与类之间是单继承的，直接父类只有一个。
 *
 * 2.类与接口之间是多实现的，一个类可以实现多个接口。
 *
 * 3.接口与接口之间是多继承的
 *
 *
 * 注意事项：
 *    1.多个父接口当中的抽象方法如果重复，没关系。
 *    2.多个父接口当中得默认方法如果，那么子接口必须进行默认方法的覆盖重写，【而且要带着default关键字】
 *      因为你是个接口啊   接口当中的default关键字是不能省略的  你是个子接口。
 */
public class InterfaceClassRelation {
}

package javabasic.interface_study.interfaceClassRelation;


/**
 * 这个子接口当中有几个方法？ 答：4个。
 *
 * methodA   来源于接口A
 * methodB   来源于接口B
 * methodComm 同时来源于接口A和B
 * method     来源于自己
 *
 *
 *
 */
public interface MyInterface extends MyInterfaceA,MyInterfaceB {

    public abstract void method();


    //当继承的这两个接口当中存在相同的默认方法的时候  此时  该接口就会报错
    //这就又出现了父亲跟母亲几个孩子这回事  母亲跟你说先吃肉 父亲跟你说先吃菜 那你觉得你这第一口吃什么呢  这个时候你总是要做出一个抉择的
    //那怎么办
    //当重写了这个方法后  发现还是带有default关键字的  愿意的话  还可以在前面写public  能不能把这个default给你删了  不能  一定要写上
     @Override
    default void methodDefault() {

    }

}

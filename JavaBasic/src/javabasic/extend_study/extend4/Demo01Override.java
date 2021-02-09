package javabasic.extend_study.extend4;

/**
 * 方法覆盖重写的注意事项：
 *  1.必须保证父子类之间的方法名称相同，参数列表也相同。
 *  @Override：写在方法上面，用来检测是不是有效的正确覆盖重写  -- @   annotation  注解
 *
 *  2.子类方法的返回值必须小于等于父类方法的返回值范围
 *    小扩展提示：java.lang.Object类是所有类的的公共最高父类（祖宗类） ，java.lang.String就是Object的子类
 *
 *  除了返回值 前面还有一个修饰符吧  那其实是权限
 *  3.子类方法的权限必须大于等于父类方法的权限修饰符。
 *     小扩展提示：public  >  protected  >  (default) > private
 *     备注：(default)不是关键字 default,而是什么都不写，留空。
 */
public class Demo01Override {
}

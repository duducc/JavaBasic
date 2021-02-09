package javabasic.thread_study.thread;

/**
 * Object类中的两个方法 wait()和notify()方法
 *   notify（）
 *   notifyAll()  唤醒所有等待的线程
 *   wait()
 *   wait(Long timeout)  该方法需要传一个参数  传long类型的毫秒值
 *
 *
 *
 *  进入到TimeWaiting（计时等待） 有两种方式
 *    1，使用sleep（Long m）方法 在毫秒值结束之后，线程唤醒进入到Runnable/Block状态
 *    2，使用wati(Long m)方法，wait方法如果在毫秒值结束之后，还没有被notify()唤醒，就会自动醒来进入到Runnable/Block状态
 *
 *    唤醒的方法：
 *      notify();
 *      notifyAll()
 */
public class ObjectWaitNotify {
}

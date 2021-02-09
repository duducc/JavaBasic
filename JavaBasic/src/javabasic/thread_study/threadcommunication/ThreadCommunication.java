package javabasic.thread_study.threadcommunication;

/**
 * 线程通信
 */

/**
 * 1.  wait():  线程不在活动，不再参于调度，进入wait set中，因此不会浪费cpu资源，也不会去竞争锁了
 *     这时的线程状态时waiting，它还要等着别的线程执行一个特别的动作，也即是 通知（notify）
 *     在这个对象上等待的线程从wait set中释放出来，重新进入调度队列中
 * 2.  notify： 则选取所通知对象的wait set中的一个线程释放；
 *              列如，餐馆有空位置后，等候就餐最久的顾客最先入座
 * 3.  notifyAll：则释放所通知对象的wait set 上的全部线程
 *
 *  注意：
 *     哪怕只通知一个等待的线程 ，被通知线程也不能立即恢复执行，因为它当初中断的地方是在同步块内，
 *     而此刻它已经不持有锁，所以它需要再次尝试去获取锁（很可能面临其他线程的竞争），成功后才能在当初调用wait方法之后的地方恢复执行。
 *
 *   总结如下：
 *      如果能获取锁，线程就从waiting状态变成runnable状态；
 *      否则 ，从wait set 出来，又进入entry set,线程就从waiting状态又变成blocked状态
 *
 *   细节：
 *      wait方法与notify方法必须要由同一个锁对象调用。因为:对应的锁对象可以通过notify唤醒使用同一个锁对象调用的wait方法后的线程
 *      wait方法与notify方法是属于Object类的方法，因为：锁对象可以是任意对象，而任意对象的所属类都是继承了Object类的
 *      wait方法与notify方法必须要在同步代码块或者是同步函数中使用。因为：必须要通过锁对象调用这2个方法
 *   等待唤醒机制其实就是经典的“生产者”与“消费者”的问题
 *
 */
public class ThreadCommunication {



}

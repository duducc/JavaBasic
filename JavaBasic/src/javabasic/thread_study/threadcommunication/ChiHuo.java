package javabasic.thread_study.threadcommunication;

/**
 * 消费者（吃货）类：是一个线程类，可以继承Thread
 * 设置线程任务（run）:吃包子
 * false:没有包子
 *    吃货调用wait()方法进入等待状态
 *  true：有包子
 *     吃货吃包子
 *     吃货吃完包子
 *     修改包子的状态为false  没有
 *     吃货唤醒包子铺线程，生产包子
 *
 */
public class ChiHuo extends  Thread{
    //1.需要在成员位置创建一个包子变量
    private BaoZi bz;

    //2.使用带参数的构造方法，为这个包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

   //设置线程任务（run）:吃包子
    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if(bz.flag==false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //
                System.out.println("吃货正在吃" + bz.pi + bz.xian + "包子");
                bz.flag=false;
                bz.notify();
                System.out.println("吃货已经把" + bz.pi + bz.xian + "的包子吃完了，包子铺开始生产包子");
                System.out.println("*********************");
            }
        }

    }
}

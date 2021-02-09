package javabasic.thread_study.thread;

/**
 * 等待唤醒案例：线程之间的通信
 *    创建一个顾客线程（消费者） ：告知老板要的包子的种类和数量，调用wait()方法，放弃cpu的执行，进入到waiting状态（无限等待）
 *    创建一个老板线程（生产者）：花了5秒做包子，做好包子之后，调用notify方法，唤醒顾客吃包子
 *
 *    注意：
 *    顾客和老板线程必须使用同步代码块包裹起来 保证等待和唤醒只能有一个在执行
 *    同步使用的锁对象必须保证唯一
 *    只有锁对象才能调用wati()或notify()方法    非锁对象是不能调用这个方法的
 *
 *    Object类中的方法
 *       void wait()
 *           在其它线程调用此对象的notify()方法或notifyAll()方法前，导致当前线程等待
 *       void notify()
 *          唤醒在此对象监视器上等待的单个线程
 *          会继续执行wait()方法之后的代码
 *
 */
public class ThreadWaitAndNotify {
    public static void main(String[] args) {
        //创建一个锁对象，保证唯一
        Object obj  = new Object();
        //创建一个顾客线程（消费者）
        new Thread(){
            @Override
            public void run() {
                //一直等着买包子
              while (true){
                  //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                  synchronized (obj){
                      System.out.println("告知老板要的包子的种类和数量");
                      //调用wait()方法，放弃cpu的执行，进入到waiting状态（无限等待）
                      try {//在这里必须try - catch   因为父类run()方法没有抛  我们也不能抛
                          obj.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      //唤醒之后执行的代码
                      System.out.println("包子已经做好了，开吃！");
                      System.out.println("***********************");
                  }
              }

            }
        }.start();

        //创建一个老板线程（生产者）
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //花了5秒做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized(obj){
                        System.out.println("老板包子做好，告知顾客，可以吃包子了");
                        //做好包子之后，调用notify方法，唤醒顾客吃包子
                        obj.notify();//唤醒之后会继续执行该同步监视器对象之前调用的wait()之后的代码
                    }
                }
            }
        }.start();

    }

}

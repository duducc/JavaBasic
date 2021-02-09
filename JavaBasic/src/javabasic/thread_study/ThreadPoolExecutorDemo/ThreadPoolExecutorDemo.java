package javabasic.thread_study.ThreadPoolExecutorDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池:
 *    可以理解为一个容器
 *       而在java中的容器- - ->集合 （ArrayList HashSet,LinkedList<Thread> 其中的（泛型）类型就是Thread线程，HashMap）
 *     当程序第一次启动的时候，创建多个线程，保存到一个集合中
 *     当我们想要使用线程的时候，就可以从集合中取出来线程使用
 *
 *     Thread t = list.remove(0);返回的是被移除的元素（线程只能被一个任务使用）
 *     Thread t = linked.removeFirst(); 移除第一个
 *     当我们是使用完毕，不是关闭了      需要把线程归还给线程池      队列的思想 依次拿出来使用
 *     list.add();
 *     linked.addlast();
 *       在jdk1.5之后，jdk内置了线程池，我们可以直接使用   这就是线程池的原理
 *
 *
 *    java.util.concurrent.Executors: 线程池的工厂类，用来生成线程池
 *     Executors类中的静态方法：
 *        static  ExecutorService newFixedThreadPool(int ntheads)  创建一个可重用固定线程的线程池
 *        参数：
 *          int  nThreads:创建线程池
 *        返回值：
 *          ExecutorService接口    ，返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口接收（面想接口编程）
 *
 *    java.util.concurrent.ExecutorService:线程池接口
 *        用来从线程池中获取线程，调用store方法，执行线程任务
 *            submit(Runnable task)  提交一个Runnable任务用于执行
 *            关闭/销毁线程池的方法
 *             void shutdown()
 *        线程池的使用步骤
 *           1，使用线程池的工厂类Executors里面提供的静态方法newFixThreadPool生产一个指定线程数量的线程池
 *           2. 创建一个类，实现Runnable接口，重写run方法，设置线程任务
 *           3. 调用ExecutorService中的方法submit，传递线程任务（实现类） ，开启线程，执行run方法
 *           4. 调用ExecutorService中的方法shutdown销毁线程池（不建议执行）
 *
 *
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //第一步
        ExecutorService executorService = Executors.newFixedThreadPool(2);//返回线程池的实现类
        //第二步    创建实现类  定义线程任务
        //第三步    调用ExecutorService中的方法submit，传递线程任务（实现类） ，开启线程，执行run方法
        executorService.submit(new RunnableImpl());
        //线程池会一直开启，使用完了线程，会自动把线程归还给线程池，线程可以继续使用
        executorService.submit(new RunnableImpl());
        executorService.submit(new RunnableImpl());
        //4.调用ExecutorService中的方法shutdown销毁线程池（不建议执行）
        executorService.shutdown();

        //再来执行  就会抛异常  ，  线程池都没有了  不能获取线程了
        executorService.submit(new RunnableImpl());
    }

}

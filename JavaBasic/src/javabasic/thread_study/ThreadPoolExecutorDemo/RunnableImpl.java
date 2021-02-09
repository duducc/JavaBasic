package javabasic.thread_study.ThreadPoolExecutorDemo;

public class RunnableImpl implements  Runnable{

    @Override
    public void run() {
        System.out.println("创建了一个新的线程"+Thread.currentThread().getName());
    }
}

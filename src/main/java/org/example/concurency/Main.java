package org.example.concurency;

public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        System.out.println(currentThread);
        System.out.println("----------------");
        printThreadState(currentThread);

        currentThread.setName("Prabowo");
        currentThread.setPriority(Thread.NORM_PRIORITY);
        printThreadState(currentThread);

        OwnThread custom = new OwnThread();
        custom.start();
    }

    /*
    get information about the current thread
     */
    public static void printThreadState(Thread thread) {
        System.out.println("----------");
        System.out.println("Thread ID : " + thread.threadId());
        System.out.println("Thrad Name : " + thread.getName());
        System.out.println("Thread Priority" + thread.getPriority());
        System.out.println("Thread State" + thread.getState());
        System.out.println("Thread Group" + thread.getThreadGroup());
        System.out.println("Thread Alive ? " + thread.isAlive());
    }
}

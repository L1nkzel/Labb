package com.uppgift4;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        PrimeThreads primeThread1 = new PrimeThreads(1,100000);
        PrimeThreads primThread2 = new PrimeThreads(100001,200000);
        PrimeThreads primThread3 = new PrimeThreads(200001,300000);
        PrimeThreads primThread4 = new PrimeThreads(300001,400000);
        PrimeThreads primThread5 = new PrimeThreads(400001,500000);
        Thread t1 = new Thread(primeThread1);
        Thread t2 = new Thread(primThread2);
        Thread t3 = new Thread(primThread3);
        Thread t4 = new Thread(primThread4);
        Thread t5 = new Thread(primThread5);

        t1.start();t1.setName("\u001B[41m\u001B[30mPrimNumThread 1");
        t2.start();t2.setName("\u001B[42m\u001B[30mPrimNumThread 2");
        t3.start();t3.setName("\u001B[43m\u001B[30mPrimNumThread 3");
        t4.start();t4.setName("\u001B[44m\u001B[30mPrimNumThread 4");
        t5.start();t5.setName("\u001B[45m\u001B[30mPrimNumThread 5");
        t1.join(); t2.join(); t3.join();t4.join();t5.join();

    }
}

class PrimeThreads implements Runnable {

    private int startNum;
    private int endNum;
    private int primeCount;

    public PrimeThreads(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.primeCount = 0;
    }

    @Override
    public synchronized void run() {

        for (int i = startNum; i <= endNum; i++) {
            int counter = 0;
            for (int num = i; num >= 1; num--) {
                if (i % num == 0) {
                    ++counter;
                }
            }
            if (counter == 2) {
                primeCount++;
            }
        }
        System.out.println(Thread.currentThread().getName() +": "+ primeCount);
    }
}


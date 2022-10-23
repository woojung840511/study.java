package ch13_thread;

/**
 * join()
 * 쓰레드 자신이 하려던 작업을 잠시 멈추고
 * 다른 쓰레드가 지정된 시간동안 작업을 수행하도록 한다.
 * 시간을 지정하지 않으면, 해당 쓰레드가 작업을 모두 마칠 때가찌 기다리게 된다.
 *
 * join()
 * join(long millis)
 * join(long millis, int nanos)
 */

public class ThreadEx19 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx19_1 th1 = new ThreadEx19_1();
        ThreadEx19_2 th2 = new ThreadEx19_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join(); // main 쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join(); // main 쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch (InterruptedException e) {}

        System.out.println("소요시간:" + (System.currentTimeMillis() - ThreadEx19.startTime));
    }
}

class ThreadEx19_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class ThreadEx19_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}
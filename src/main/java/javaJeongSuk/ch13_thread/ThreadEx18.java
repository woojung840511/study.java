package javaJeongSuk.ch13_thread;


/**
 * yield() - 다른 쓰레드에게 양보한다.
 */
public class ThreadEx18 {

    public static void main(String[] args) {
        ThreadEx18_1 th1 = new ThreadEx18_1("*");
        ThreadEx18_1 th2 = new ThreadEx18_1("**");
        ThreadEx18_1 th3 = new ThreadEx18_1("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(3000);
            th3.stop();
        } catch (InterruptedException e) {}
    }
}

class ThreadEx18_1 implements Runnable {

    boolean suspended = false;
    boolean stopped = false;

    Thread th;

    public ThreadEx18_1(String name) {
        this.th = new Thread(this, name);  // Thread (Runnable r, String name)
    }

    @Override
    public void run() {
        String name = th.getName();

        while (!stopped) {
            if (!suspended) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(name + " - interrupted"); // interrupt()가 호출되면, 예외가 발생된다.
                }
            } else {
                Thread.yield(); // 추가됨. 효율과 응답성 향상
            }
        }

        System.out.println(name + " - stopped");
    }

    public void suspend() {
        suspended = true;
        th.interrupt();
        System.out.println(th.getName() + " -  interrupted() by suspend()");
    }

    public void stop() {
        stopped = true;
        th.interrupt();
        System.out.println(th.getName() + " -  interrupted() by stop()");
    }

    public void resume() {
        suspended = false;
    }

    public void start() {
        th.start();
    }
}

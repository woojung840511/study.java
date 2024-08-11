package thread.bable;

public class ThreadEx15 {

    /**
    suspend() : 쓰레드를 일시정지 상태로 만든다.
    resume() : suspend()로 일시정지 상태인 쓰레드를 다시 실행대기 상태로 만든다.
    stop() : 쓰레드를 강제종료시킨다.

    suspend(), resume(), stop()은 사용하지 않는 것이 좋다.
     */

    public static void main(String[] args) {
        RunImplEx15 r = new RunImplEx15();
        Thread th1 = new Thread(r, "*");
        Thread th2 = new Thread(r, "**");
        Thread th3 = new Thread(r, "***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            System.out.println("th1 suspend");
            Thread.sleep(2000);
            th2.suspend();
            System.out.println("th2 suspend");
            Thread.sleep(3000);
            th1.resume();
            System.out.println("th1 resume");
            Thread.sleep(3000);
            th1.stop();
            System.out.println("th1 stop");
            th2.stop();
            System.out.println("th2 stop");
            Thread.sleep(2000);
            th3.stop();
            System.out.println("th3 stop");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }



}

class RunImplEx15 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

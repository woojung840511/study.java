package ch13_thread;

public class ThreadEx1 {

    public static void main(String[] args) {
        ThreadEx1_1 t1 = new ThreadEx1_1(); // Thread 자손 클래스의 인스턴스를 생성

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r); // 생성자 Thread (Runnable target)

        t1.start();
        t2.start();
    }
}

class ThreadEx1_1 extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}

class ThreadEx1_2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread() 현재 실행 중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}

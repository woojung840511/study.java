package thread.yalco;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            try {
                // 😴 0.5초간 일시 정지
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread.currentThread() 현재 실행중인 thread 를 반환
            System.out.print(Thread.currentThread().getName() + "[2]");
        }
    }
}

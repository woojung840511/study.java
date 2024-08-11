package thread.yalco;

public class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            try {
                // 😴 0.5초간 일시 정지
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 조상인 Thread 의 getName() 호출
            System.out.print(getName() + "[1]");
        }
    }
}

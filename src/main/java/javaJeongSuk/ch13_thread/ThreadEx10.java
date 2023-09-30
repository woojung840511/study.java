package javaJeongSuk.ch13_thread;

/**
 * 데몬 쓰레드는 다른 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행하는 쓰레드.
 * - 데몬 쓰레드는 일반 쓰레드가 모두 종료되면 강제로 자동 종료된다.
 *   (일반 쓰레드가 종료되고 나면 데몬 쓰레드의 존재의 의미가 없기 때문)
 * - 데몬 쓰레드의 예: 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신
 * - 데몬 쓰레드는 무한루프와 조건문을 이용해서 실행 후 대기하고 있다가 특정 조건이 만족되면
 * 작업을 수행하고 다시 대기하도록 작성한다..(?)
 * - 데몬 쓰레드는 일반 쓰레드의 작성방법과 실행방법이 같으며 다만 쓰레드를 생성한 다음 실행하기 전에 
 *   setDaemon(true)를 호출하기만 하면 된다. 
 * - 데몬 쓰레드가 생성한 쓰레드는 자동적으로 데몬 쓰레드가 된다.
 *
 */


public class ThreadEx10 implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {

        Thread t = new Thread(new ThreadEx10());
        t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다.
        t.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.println("i = " + i);

            if (i == 5) {
                autoSave = true;
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }


    @Override
    public void run() {
        // 3초마다 autoSave의 값을 확인해서 그 값이 true이면 autoSave() 호출
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {}

            // autoSave의 값이 true이면 autoSave()를 호출한다.
            if (autoSave) {
                autoSave();
            }
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다");
    }
}

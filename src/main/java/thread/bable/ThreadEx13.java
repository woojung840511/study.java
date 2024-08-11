package thread.bable;

import javax.swing.JOptionPane;

/**
 * interrupt()와 interrupted() - 쓰레드의 작업을 취소한다
 */

public class ThreadEx13 {

    public static void main(String[] args) {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + " 입니다");

        th1.interrupt(); // interrupt()를 호출하면, interrupted 상태가 true가 된다.

        /**
         *
         * void interrupt()
         * - 쓰레드의 interrupted 상태(인스턴스 변수)를 false에서 true로 변경함
         * - 강제로 종료시키는 것은 아니고, 쓰레드가 스스로 종료할 수 있도록 유도, 단지 플래그를 변경
         *
         * boolean isInterrupted()
         * - 쓰레드의 interrupted 상태를 반환
         *
         * static boolean interrupted()
         * - 현재 쓰레드의 interrupted 상태를 반환하고, false로 초기화
         *
         * 쓰레드가 RUNNABLE 상태에 있을때 , interrupt()를 호출하면,
         * -> interrupted 상태가 true가 된다.
         * -> interrupted 상태가 true가 되면, 쓰레드는 interrupted 상태를 확인하여 적절한 조치를 취해야 한다.
         *
         * 쓰레드가 sleep(), wait(), join()에 의해 일시정지 상태(WAITING)에 있을 때, interrupt()를 호출하면,
         * -> 쓰레드는 InterruptedException을 발생시키고
         * -> interrupted 상태는 false로 초기화 된다.
         * -> 쓰레드의 상태는 실행대기 상태(RUNNABLE)이 된다.
         */
        System.out.println("th1.isInterrupted() = " + th1.isInterrupted()); // true
    }


}

class ThreadEx13_1 extends Thread {

    @Override
    public void run() {
        int i = 10;

        /**
         * boolean isInterrupted() 쓰레드의 interrupted 상태를 반환             *
         */
        while (i != 0 && !isInterrupted()) {

            System.out.println(i--);

            for (long x = 0; x < 2500000000L; x++) {} // 시간 지연
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
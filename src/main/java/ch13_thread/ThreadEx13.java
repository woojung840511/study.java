package ch13_thread;

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
         * - 쓰레드에게 작업을 멈추라고 요청.
         * - 강제로 종료시키는 것은 아니고,
         * - 쓰레드의 interrupted 상태(인스턴스 변수)를 false에서 true로 변경함
         *
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
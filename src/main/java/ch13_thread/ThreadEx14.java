package ch13_thread;

import javax.swing.JOptionPane;

/**
 * interrupt()와 interrupted() - 쓰레드의 작업을 취소한다
 */


public class ThreadEx14 {

    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + " 입니다");

        th1.interrupt(); // interrupt()를 호출하면, interrupted 상태가 true가 된다.
        System.out.println("th1.isInterrupted() = " + th1.isInterrupted()); // true
    }
}

class ThreadEx14_1 extends Thread {

    @Override
    public void run() {
        int i = 100;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);

            try {
                Thread.sleep(1000); // 1초 지연
            } catch (InterruptedException e) {
                interrupt();

                /**
                 * sleep()에 의해 쓰레드가 잠시 멈춰있을 때
                 * interrupt()를 호출하면
                 * InterruptedException이 발생되고
                 * 쓰레드의 interrupted 상태는 false로 자동 초기화된다.
                 *
                 * 이럴 때는 위와 같이 catch 블럭에 interrupt()를 추가로 넣어줘서
                 * 쓰레드의 interrupted 상태를 true로 다시 바꿔줘야 한다.
                 */
            }

        }

        System.out.println("카운트가 종료되었습니다");
    }
}

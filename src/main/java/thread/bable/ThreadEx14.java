package thread.bable;

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
         *
         *
         * 1. RUNNABLE 상태의 스레드:
         *    - 맞습니다. interrupt() 메소드가 호출되면 interrupted 상태만 true로 변경됩니다.
         *    - 스레드는 계속 실행되며, 개발자가 명시적으로 interrupted 상태를 확인하고 처리해야 합니다.
         *
         * 2. WAITING 또는 TIMED_WAITING 상태의 스레드:
         *    - interrupt() 메소드가 호출되면 다음과 같은 일이 발생합니다:
         *      a) interrupted 상태가 true로 설정됩니다.
         *      b) 스레드가 블로킹 상태에서 빠져나옵니다.
         *      c) InterruptedException이 발생합니다.
         *    - 여기서 중요한 점은 InterruptedException이 발생할 때 interrupted 상태가 자동으로 초기화(false로 재설정)된다는 것입니다.
         *
         * 추가적인 주의사항:
         *
         * 1. BLOCKED 상태:
         *    - 스레드가 synchronized 블록이나 메소드에 진입하기 위해 대기 중일 때는 interrupt()를 호출해도 즉시 반응하지 않습니다.
         *    - 락을 획득한 후에야 interrupted 상태를 확인할 수 있습니다.
         *
         * 2. InterruptedException 처리:
         *    - InterruptedException을 catch 했을 때, 일반적으로 다음 두 가지 중 하나를 수행해야 합니다:
         *      a) 예외를 상위로 전파
         *      b) 현재 스레드의 interrupt 상태를 다시 설정 (Thread.currentThread().interrupt())
         *
         * 3. 인터럽트 상태 확인:
         *    - Thread.interrupted(): 현재 스레드의 인터럽트 상태를 반환하고 false로 초기화합니다.
         *    - thread.isInterrupted(): 스레드의 인터럽트 상태만 반환하고 초기화하지 않습니다.
         *
         */
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

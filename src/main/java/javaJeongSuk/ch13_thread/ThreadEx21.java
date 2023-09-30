package javaJeongSuk.ch13_thread;

/**
 * 멀티쓰레드 프로세스의 경우 여러 쓰레드가 같은 프로세스 내의 자원을 공유해서 작업하기 때문에
 * 서로의 작업에 영향을 주게 된다.
 * 만일 쓰레드 A가 작업하던 도중에 쓰레드 B에게 제어권이 넘어갔을 때,
 * 쓰레드 A가 작업하던 공유데이터를 쓰레드 B가 임의로 변경하였다면,
 * 다시 쓰레드 A가 제어권을 받아서 나머지 작업을 마쳤을 때 원래 의도했던 것과는 다른 결과를 얻을 수 있다.
 *
 * 이러한 일이 발생하는 것을 방지하기 위해서
 * 한 쓰레드가 특정 작업을 끝마치기 전까지 다른 쓰레드에 의해 방해받지 않도록 하는 것이 필요하다.
 * 그래서 도입된 개념이 바로 임계 영역(critical section)과
 * 잠금(락, lock)이다.
 *
 * 공유 데이터를 사용하는 코드 영역을 임계 영역으로 지정해놓고,
 * 공유 데이터(객체)가 가지고 있는 lock을 획득한 단 하나의 쓰레드만 이 영역 내의 코드를 수행할 수 있게 한다.
 * 그리고 해당 쓰레드가 임계 영역 내의 모든 코드를 수행하고 벗어나서 lock을 반납해야만
 * 다른 쓰레드가 반납된 lock을 획득하여 임계 영역의 코드를 수행할 수 있게 된다.
 *
 * 이처럼 한 쓰레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것을 '쓰레드'의 동기화(Synchronization)'이라고 한다.
 *
 */

public class ThreadEx21 {

    public static void main(String[] args) {
        Runnable r = new RunnableEx21();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void withdraw (int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
                balance -= money;
            } catch (InterruptedException e) {}
        }
    } // withdrqw
}

class RunnableEx21 implements Runnable {
    Account acc = new Account();

    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            // 100, 200, 300 중의 한 값을 임의로 선택해서 출금 (withdraw)
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.getBalance());
        }
    } // run()
}

/**
 *
 * main 실행결과는 다음과 같다.
 *
 * balance : 600
 * balance : 600
 * balance : 500
 * balance : 400
 * balance : 200
 * balance : 100
 * balance : 100
 * balance : -100
 * balance : -200
 *
 *
 * 잔고(balance)가 음수가 된 것을 확인할 수 있다.
 * 한 쓰레드가 if문의 조건식을 통과하고 출금하기 직전에 다른 쓰레드가 끼어들어서 출금을 먼저 했기 때문이다.
 *
 *
 *
 */
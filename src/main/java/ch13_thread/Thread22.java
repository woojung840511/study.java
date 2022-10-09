package ch13_thread;

/**
 *
 */


public class Thread22 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx22();
        new Thread(r).start();
        new Thread(r).start();
    }

}

class Account2 {

    /**
     * private 으로 해야 동기화가 의미가 있다.
     * 만일 private 가 아니면, 외부에서 직접 접근할 수 있기 때문에 아무리 동기화를 해도 이 값의 변경을 막을 길이 없다.
     * synchronized 를 이용한 동기화는 지정된 영역의 코드를 한 번에 하나의 쓰레드가 수행하는 것을 보장하는 것 뿐이다.
     */
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    // 1 번째 동기화 방식 : 메서드 전체를 임계 영역으로 지정
    public synchronized void withdraw (int money) { // synchronized 로 메서드를 동기화
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            balance -= money;
        }
    }

/*
    // 2 번째 동기화 방식 : 특정한 영역을 임계 영역으로 지정
    synchronized (객체의 참조변수) {}
    메서드 내의 코드 일부를 위와 같이 블럭 {} 으로 감싸고 블럭 앞에 'synchronized (참조변수)' 를 붙이는 것인데
    이때 참조변수는 락을 걸고자하는 객체를 참조하는 것이어야 한다.

    public void withdraw (int money) {
        synchronized (this) {
            if (balance >= money) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                balance -= money;
            }
        }
    }

    이 블럭을 synchronized 블럭이라고 부르며, 이 블럭의 영역 안으로 들어가면서부터는 쓰레드는 지정된 객체의 lock을 얻게 되고
    이 블럭을 벗어나면 lock을 반납한다.

    1번째, 2번째 방법 모두 lock의 획득과 반납이 모두 자동적으로 이루어지므로 우리가 해야 할 일은 그저 임계 영역만 설정해주는 것 뿐이다.

    모든 객체는 lock을 하나씩 가지고 있으며,
    해당 객체의 lock을 가지고 있는 쓰레드만 임계 영역의 코드를 수행할 수 있다. 그리고 다른 쓰레드들은 lock을 얻을 때까지 기다리게 된다.

    임계 영역은 멀티쓰레드 프로그램의 성능을 좌우하기 때문에 가능하면 메서드 전체에 락을 거는 것보다
    synchronized 블럭으로 임계 영역을 최소화해서 보다 효율적인 프로그램이 되도록 노력해야 한다.

    */
}

class RunnableEx22 implements Runnable {
    Account2 acc = new Account2();

    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.getBalance());
        }

    }
}
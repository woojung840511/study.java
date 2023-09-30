package javaJeongSuk.ch14_LamdaAndStream;

@FunctionalInterface
interface MyFunction {
    void run(); // public abstract void run();
}

public class LamdaEx1 { // 함수형 인터페이스

    public static void main(String[] args) {
        // 람다식으로 MyFunction의 run을 구현
        MyFunction f1 = () -> System.out.println("f1.run()");

        // 익명 클래스로 MyFunction의 run을 구현
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() { // public을 반드시 붙여야 함.
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f3);
        execute(() -> System.out.println("run()"));

    }

    static void execute (MyFunction f) { // 매개변수의 타입이 MyFunction인 메서드드
        f.run();
    }

    static MyFunction getMyFunction() { // 반환 타입이 MyFunction인 메서드
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }
}




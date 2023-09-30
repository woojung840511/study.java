package javaJeongSuk.ch14_LamdaAndStream;

@FunctionalInterface
interface MyFunctionEx3 {
    void myMethod();
}

class Outer {
    int val = 10; // Outer.this.val

    class Inner {
        int val = 20; // this.val

        void method (int i) { // void method (final int i) {
            int val = 30;
//            i = 10; // 에러. 상수의 값을 변경할 수 없음.

            MyFunctionEx3 f = () -> {
                System.out.println("i = " + i); // 상수로 간주. 변경 안됨
                System.out.println("val = " + val); // 상수로 간주. 변경 안됨
                System.out.println("++this.val = " + ++this.val);
                System.out.println("++Outer.this.val = " + ++Outer.this.val);
            };

            f.myMethod();
        }

    } // Inner class 끝

} // Outer class 끝

public class LamdaEx3 { // 외부 변수를 참조하는 람다식
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}

/*
    - 람다식 내에서 참조하는 지역변수는 final이 붙지 않았어도 상수로 간주된다.
    - 람다식 내에서 지역변수 i 와 val을 참조하고 있으므로 람다식 내에서나 다른 어느 곳에서도 이 변수들의 값을 변경하는 일은 허용되지 않는다.

    - 반면 inner 클래스와 outer 클래스의 인스턴스 변수인 this.val과 Outer.this.val은 상수로 간주되지 않으므로 값을 변경해도 된다.
    - 외부 지역변수와 같은 이름의 람다식 매개변수는 허용되지 않는다.
 */
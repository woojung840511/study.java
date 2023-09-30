package javaJeongSuk.ch14_LamdaAndStream;

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}

public class LamdaEx2 { // 람다식의 타입과 형변환

    public static void main(String[] args) {
        MyFunction2 f = () -> {}; // MyFunction2 f = MyFunction (() -> {});
        Object obj = (MyFunction)(() -> {}); // Object 타입으로 형변환이 생략됨
        String str = ((Object)(MyFunction)(() -> {})).toString(); // 굳이 Object  타입으로 형변환하려면, 먼저 함수형 인터페이스로 변환해야 한다.

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

//        System.out.println(() -> {}); // 에러. 람다식은 Object 타입으로 형변환 안됨
        System.out.println((MyFunction)(() -> {}));
//        System.out.println((MyFunction)(() -> {}).toString()); // 에러
        System.out.println(((Object)(MyFunction)(() -> {})).toString());
    }
}

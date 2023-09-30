package javaJeongSuk.ch14_LamdaAndStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        ArrayList<Inner1> inner1s = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Inner1 inner1 = new Inner1(i);
            inner1s.add(inner1);
        }

        ArrayList<Outer1> outer1s = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Outer1 outer1 = new Outer1(inner1s);
            outer1s.add(outer1);
        }

        outer1s.stream()
            .flatMap( o -> Stream.of(o.inner1List))
            .flatMap(Collection::stream)
            .map(inner1 -> inner1.i)
            .forEach(System.out::println);

        // 맵은 스트림 안에 또다른 스트림을 생성하지만
        // 플랫맵은 하나의 스트림 안에 배열이나 콜랙션을 풀어넣어준다
    }
}

class Outer1 {
    List<Inner1> inner1List;

    public Outer1(List<Inner1> inner1List) {
        this.inner1List = inner1List;
    }
}

class Inner1 {
    int i;

    public Inner1(int i) {
        this.i = i;
    }
}
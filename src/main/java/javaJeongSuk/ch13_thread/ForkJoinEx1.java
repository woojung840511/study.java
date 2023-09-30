package javaJeongSuk.ch13_thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {

    static final ForkJoinPool pool = new ForkJoinPool(); // 쓰레드 풀을 생성

    public static void main(String[] args) {
        long from = 1L, to = 100_000_000L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);
        System.out.println("Elapsed time(8 core) : " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        System.out.println();
    }


}

class SumTask extends RecursiveTask<Long> {

    long from, to;

    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {

        long size = to - from + 1; // from <= i <= to

        if (size <= 5)
            return sum(); // 숫자의 합을 반환

        long half = (from + to) / 2;

        // 범위를 반으로 나눠서 두개의 작업을 생성
        SumTask leftSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half + 1, to);

        leftSum.fork();
        // fork() : 해당 작업을 쓰레드 풀의 작업 큐에 넣는다. 비동기 메서드. 호출 후 작업을 기다리지 않는다.

        return rightSum.compute() + leftSum.join();
        // join() : 해당 작업의 수행이 끝날 때까지 기다렸다가 수행이 끝나면 그 결과를 반환한다. 동기 메서드
    }

    private long sum() {
        long tmp = 0L;

        for (long i = from; i <= to; i++) {
            tmp += i;
        }

        return tmp;
    }


}
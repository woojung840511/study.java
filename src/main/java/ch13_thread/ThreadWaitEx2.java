package ch13_thread;

import java.util.ArrayList;

/**
 * 손님 쓰레드가 테이블 객체의 lock을 쥐고 기다리기 때문이다.
 */

public class ThreadWaitEx2 {

    public static void main(String[] args) throws InterruptedException {
        Table2 table = new Table2(); // 여러 쓰레드가 공유하는 객체

        new Thread(new Cook2(table), "COOK1").start();
        new Thread(new Customer2(table, "donut")).start();
        new Thread(new Customer2(table, "burger")).start();

        Thread.sleep(5000); //강제 종료시킨다.
        System.exit(0); // 프로그램 전체를 종료. (모든 쓰레드가 종료됨.)

    }
}

class Customer2 implements Runnable {

    private Table2 table;
    private String food;

    public Customer2(Table2 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            if (eatFood()) {
                System.out.println(name + " ate a " + food);
            } else {
                System.out.println(name + " failed to eat. : " + food);
            }
        }
    }

    boolean eatFood() {
        return table.remove(food);
    }
}

class Cook2 implements Runnable {

    private Table2 table;

    public Cook2(Table2 table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            // 임의의 요리를 하나 선택해서 table에 추가한다.
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
        }
    }
}

class Table2 {

    String[] dishNames = {"donut", "donut", "burger"}; // donut이 더 자주 나온다.
    final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수

    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        // 테이블에 음식이 가득 찼으면, 테이블에 음식을 추가하지 않는다.
        if (dishes.size() >= MAX_FOOD) {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes : " + dishes.toString());
    }

    public boolean remove(String dishName) {

        synchronized (this) {
            while (dishes.size() == 0) { // 0.5초마다 음식이 추가되었는지 확인한다.
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {Thread.sleep(500); } catch (InterruptedException e) {}
            }

            // 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
            for (int i = 0; i < dishes.size(); i++) {
                if (dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    public int dishNum() {
        return dishNames.length;
    }
}

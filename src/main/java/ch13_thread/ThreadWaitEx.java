package ch13_thread;

import java.util.ArrayList;

public class ThreadWaitEx {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2(); // 여러 쓰레드가 공유하는 객체

        /**
         * 여러 쓰레드가 테이블을 공유하지만 동기화를 하지 않아서 다음과 같은 예외가 발생하게 된다.
         * CurrentModificationException:
         *  요리사 Cook 쓰레드가 테이블에 음식을 놓는 도중에
         *  손님 Customer 쓰레드가 음식을 가져가려고 해서 발생
         *
         * IndexOutOfBoundsException:
         *  손님 쓰레드가 테이블의 마지막 남은 음식을 가져가는 도중에 다른 손님 쓰레드가 먼저 음식을 낚아채버려서
         *  있지도 않은 음식을 테이블에서 제거하려 했기 때문에 발생하는 예외
         *
         */

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(1000);     // 0.1초 (100 밀리 세컨드) 후에 강제 종료시킨다.
        System.exit(0);        // 프로그램 전체를 종료. (모든 쓰레드가 종료됨)
    }
}




class Customer implements Runnable {
    private Table2 table;
    private String food;

    public Customer(Table2 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

            String name = Thread.currentThread().getName();

            if (eatFood()) {
                System.out.println(name + " ate a " + food);
            } else {
                System.out.println(name + " failed to eat " + food + " :(");
            }
        }
    }

    boolean eatFood() {
        return table.remove(food);
    }
}

class Cook implements Runnable {

    private Table2 table;

    Cook(Table2 table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            // 임의의 요리를 하나 선택해서 table에 추가한다.
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }

        }
    }
}



class Table {
    String[] dishNames = {"donut", "donut", "burger"}; // donut이 더 자주 나온다.
    final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수

    private ArrayList<String> dishes = new ArrayList<>();

    public void add(String dish) {
        // 테이블에 음식이 가득 찼으면, 테이블에 음식을 추가하지 않는다.
        if (dishes.size() >= MAX_FOOD) return;
        dishes.add(dish);
        System.out.println("Dishes : " + dishes.toString());
    }

    public boolean remove(String dishName) {
        // 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
        for (int i = 0; i < dishes.size(); i++) {
            if (dishName.equals(dishes.get(i))) {
                dishes.remove(i);
                return true;
            }
        }
        return false;
    }

    public int dishNum() {
        return dishNames.length;
    }
}

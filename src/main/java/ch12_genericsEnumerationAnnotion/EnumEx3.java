package ch12_genericsEnumerationAnnotion;


// 열거형에 추상 메서드 'fare(int distance)'를 선언하면 각 열거형 상수가 이 추상 메서드를 반드시 구현해야 한다.

enum Transportation {
    BUS(100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    TRAIN(150) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    SHIP(100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    AIRPALNE(300) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    protected final int BASIC_FARE; //  protected로 해야 각 상수에서 접근 가능

    Transportation(int basicFare) { // private Transportation(int basicFare)
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() {
        return BASIC_FARE;
    }

    abstract int fare(int distance);
    // 열거형에 추상 메서드 'fare(int distance)'를 선언하면 각 열거형 상수가 이 추상 메서드를 반드시 구현해야 한다.

}


public class EnumEx3 {

    public static void main(String[] args) {
        System.out.println("bus fare = " + Transportation.BUS.fare(100));
        System.out.println("train fare = " + Transportation.TRAIN.fare(100));
        System.out.println("ship fare = " + Transportation.SHIP.fare(100));
        System.out.println("airplane fare = " + Transportation.AIRPALNE.fare(100));
    }
}

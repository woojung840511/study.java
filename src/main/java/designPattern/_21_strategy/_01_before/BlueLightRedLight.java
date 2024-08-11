package designPattern._21_strategy._01_before;

public class BlueLightRedLight {

    private int speed;

    public BlueLightRedLight(int speed) {
        this.speed = speed;
    }

    public void blueLight() {

        if (speed == 1) {
            System.out.println("무 궁 화   꽃   이");
        } else if (speed == 2) {
            System.out.println("무궁화꽃이");
        } else {
            System.out.println("무궁꼬시");
        }
    }

    public void redLight() {
        if (speed == 1) {
            System.out.println("피 었 습 니 다.");
        } else if (speed == 2) {
            System.out.println("피었습니다.");
        } else {
            System.out.println("피었슴다");
        }
    }

}

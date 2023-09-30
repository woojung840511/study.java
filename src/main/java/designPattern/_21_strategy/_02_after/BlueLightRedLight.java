package designPattern._21_strategy._02_after;

public class BlueLightRedLight {

    // 방식 1) 생성자로 넘겨주기
/*
    private Speed speed;

    public BlueLightRedLight(Speed speed) {
        this.speed = speed;
    }

    public void blueLight() {
        speed.blueLight();
    }

    public void redLight() {
        speed.redLight();
    }*/

    // 방식 2) method 파라미터로 넘겨주기
    public BlueLightRedLight() {
    }

    public void blueLight(Speed speed) {
        speed.blueLight();
    }

    public void redLight(Speed speed) {
        speed.redLight();
    }
}

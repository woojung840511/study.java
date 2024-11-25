package thread.yalco.ch_06.ex1;

public class Cave {
    private int water = 40;

    public int getWater() {
        return water;
    }
    public void pump() {
        if (getWater() > 0) water--;
    }
}

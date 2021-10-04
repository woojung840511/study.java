package Date와Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date01 {

    public static void main(String[] args) throws InterruptedException {

        // JAVA8 이전 기존에 있던 Date와 관련된 라이브러리들
//        Date date = new date();
//        Calendar calendar = new GregorianCalendar();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        Date date = new Date();
        long time = date.getTime();
        System.out.println("date = " + date);
        System.out.println("time = " + time);

        Thread.sleep(3 * 1000);
        Date after3seconds = new Date();
        System.out.println("after3seconds = " + after3seconds);
        after3seconds.setTime(time);
        System.out.println("after3seconds = " + after3seconds);
    }
}

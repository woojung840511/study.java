package ch13_thread;

public class ThreadEx2 {

    public static void main(String[] args) {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
    }


    /*
    java.lang.Exception
	at ch13_thread.ThreadEx2_1.throwException(ThreadEx2.java:19)
	at ch13_thread.ThreadEx2_1.run(ThreadEx2.java:14)

	와 같은 결과가 나타남
	main thread가 보이지 않는 이유는 이미 종료되었기 때문.
     */
}

class ThreadEx2_1 extends Thread {

    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

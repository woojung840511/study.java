package ch14_LamdaAndStream.myTest;

public class App {

    public static void main(String[] args) {
        doTest(DataSupplier.wjSupplier);
        doTest(() -> new Data(3, "hello"));
    }

    public static void doTest(DataSupplier dataSupplier) {
        Data data = dataSupplier.getData();
        System.out.println(data);
    }
}

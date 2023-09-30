package javaJeongSuk.ch14_LamdaAndStream.myTest;

@FunctionalInterface
interface DataSupplier {

    Data getData();

    DataSupplier DefaultSupplier = () -> new Data(0, "default");

    DataSupplier wjSupplier = () -> new Data(0, "wj");

}

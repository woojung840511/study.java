package codingTest.inflearn.javaAlgorithm._03_문장_속_단어;

public class Test {

    public static void main(String[] args) {
        String str = "Hello world! wow !";
        int firstIndex = str.indexOf("!");
        int secondIndex = str.indexOf("!", firstIndex + 1);

        System.out.println("firstIndex = " + firstIndex);
        System.out.println("secondIndex = " + secondIndex);
    }
}
